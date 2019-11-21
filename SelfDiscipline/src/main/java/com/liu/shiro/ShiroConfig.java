package com.liu.shiro;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ShiroConfig {
	
	
	@Value("${spring.redis.host}")
    private String redisHost;
 
    @Value("${spring.redis.port}")
    private int redisPort;
 
    @Value("${spring.redis.password}")
    private String redisPassword;

	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {		
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
        //自定义拦截器
        Map<String, Filter> filtersMap = new LinkedHashMap<String, Filter>();
        //限制同一帐号同时在线的个数。
//        filtersMap.put("kickout", kickoutSessionControlFilter());
//        shiroFilter.setFilters(filtersMap);
        
		//拦截器.
		Map<String,String> hashMap = new LinkedHashMap<String,String>();
		hashMap.put("/login", "anon");

		
		hashMap.put("/**", "anon");
		
		shiroFilter.setFilterChainDefinitionMap(hashMap);	
		return shiroFilter;

	}
	
	@Bean
	public DefaultWebSecurityManager securityManager(){
		 DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		 securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
		 securityManager.setSessionManager(sessionManager());
		 securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
	 

	@Bean(name = "ehCacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
        public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();      
        return ehCacheManager;
    }
	  /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setKeyPrefix("token_cache:");   //设置前缀
        return redisCacheManager;
    }
    
    /**
     * 配置shiro redisManager
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisHost);
        redisManager.setPort(redisPort);
        redisManager.setTimeout(60); //设置过期时间
        redisManager.setPassword(redisPassword);
        return redisManager;
    }
    
    /**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public SessionManager sessionManager() {
        SimpleCookie simpleCookie = new SimpleCookie("Token");
        simpleCookie.setPath("/");
        simpleCookie.setHttpOnly(false);
        //自定义的SessionManager类
        SessionManager sessionManager = new SessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        sessionManager.setSessionIdCookieEnabled(false);
       // sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }
    
    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setKeyPrefix("UserToken:");
        return redisSessionDAO;
    }

    /**
     * 限制同一账号登录同时登录人数控制
     *
     * @return
     */
//    @Bean
//    public SessionControlFilter kickoutSessionControlFilter() {
//        SessionControlFilter kickoutSessionControlFilter = new SessionControlFilter();
//        kickoutSessionControlFilter.setCache(cacheManager());
//        kickoutSessionControlFilter.setSessionManager(sessionManager());
//        kickoutSessionControlFilter.setKickoutAfter(false);
//        kickoutSessionControlFilter.setMaxSession(1);
//        kickoutSessionControlFilter.setKickoutUrl("/common/kickout");
//        return kickoutSessionControlFilter;
//    }



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
	/**
	 * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
	 * @return
	 */
	@Bean
	public ShiroRealm myShiroRealm(){
		ShiroRealm myShiroRealm = new ShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}


	
	
	
	
	
	/**
     * Shiro生命周期处理器
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

	
    /**
                 * 授权所用配置
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
