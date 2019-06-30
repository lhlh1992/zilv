package com.liu.shiro;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ShiroConfig {
	
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {		
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		  /**
         * 登陆成功后跳转的url
         */
        shiroFilter.setSuccessUrl("/");
        
        /**
         * 配置shiro拦截器链
         *
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         *
         * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
         *
         * 顺序从上到下,优先级依次降低
         *
         * api开头的接口，走rest api鉴权，不走shiro鉴权
         *
         */
        
		//拦截器.
		Map<String,String> hashMap = new LinkedHashMap<String,String>();
//		hashMap.put("/user/**", "authc");
//		hashMap.put("/dic/**", "authc");
		hashMap.put("/**", "anon");
		// 配置不会被拦截的链接 顺序判断
		//filterChainDefinitionMap.put("/static/**", "anon");
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		//filterChainDefinitionMap.put("/logout", "logout");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		//filterChainDefinitionMap.put("/static/templates/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		//shiroFilterFactoryBean.setLoginUrl("/login/loginUser");
		// 登录成功后要跳转的链接
		//shiroFilterFactoryBean.setSuccessUrl("/login/home");

		//未授权界面;
		//shiroFilterFactoryBean.setUnauthorizedUrl("/base/error");
		shiroFilter.setFilterChainDefinitionMap(hashMap);
		return shiroFilter;

	}
	

	@Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
        public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
    }
	
	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * ）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(1024);
		//hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public ShiroRealm myShiroRealm(){
		ShiroRealm myShiroRealm = new ShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}


	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		 securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
		 securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	
	
	
	/**
     * Shiro生命周期处理器
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

	
    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证   AOP式方法级权限检查
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		System.out.println("开启shiro aop注解支持.");
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver
	createSimpleMappingExceptionResolver() {
		System.out.println("oooooooooooooooooooooo");
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "/base/databaseError");//数据库异常处理
		mappings.setProperty("UnauthorizedException","/base/error");
		r.setExceptionMappings(mappings);  // None by default
		//r.setDefaultErrorView("error");    // No default
		r.setDefaultErrorView("/base/login");    // 访问错误，直接访问登录页面
		r.setExceptionAttribute("ex");     // Default is "exception"
		//r.setWarnLogCategory("example.MvcLogger");     // No default
		return r;
	}



}
