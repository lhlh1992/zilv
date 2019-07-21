package com.liu.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IRoleService;
import com.liu.mvc.service.IUserService;

public class ShiroRealm extends AuthorizingRealm{
	
	@Resource
	private IUserService userService;
	@Resource
	private IRoleService roleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		  System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		
	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	      
	        	User u=new User();
	 	        u.setUsername(String.valueOf(principals.getPrimaryPrincipal()));
	 	        List<User> userInfoList = userService.getUserList(String.valueOf(principals.getPrimaryPrincipal()));
	 	        User userInfo=userInfoList.get(0);
	 	        List<Role> roleList = userInfo.getRoleList();
		        for(Role role:roleList){        	
		            authorizationInfo.addRole(role.getRolename());
		            List<Role> r = roleService.getRoleList(role.getRolename());
		            Role ro = r.get(0);
		            for(Perm p:ro.getPerList()){
		                authorizationInfo.addStringPermission(p.getPermissionName());
		            }
		        }
		       System.out.println("获取到以下权限=============");
		       System.out.println(authorizationInfo.getStringPermissions().toString());
		       
	     
	        
	        return authorizationInfo;
	
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		  System.out.println("MyShiroRealm.doGetAuthenticationInfo()，认证方法");
	        //获取用户的输入的账号.
		  	UsernamePasswordToken to = (UsernamePasswordToken) token;	  	
	        String username = String.valueOf(to.getUsername());
	        //通过username从数据库中查找 User对象，如果找到，没找到.
	        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
	        User u=new User();
	        u.setUsername(username);
	        User userInfo = userService.getUser(u);
	        if(userInfo == null){
	            return null;
	        }
	       
	        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
	        		userInfo.getUsername(), //用户名
	                userInfo.getPassword(), //密码
	                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt 盐值
	                getName()  //realm name   
	        );
	        return simpleAuthenticationInfo;
	}

}
