package com.liu.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IPermService;
import com.liu.mvc.service.IRoleService;
import com.liu.mvc.service.IUserService;



@Controller
@CrossOrigin
public class LoginController {

	@Resource
	private IPermService permService;
	
	@Resource
	private IRoleService roleService;
	   		

    /**
     * ajax登录请求接口方式登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(@RequestBody Map<String,String> json,ServletRequest request) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String username = json.get("username").toString();
  	    String password = json.get("password").toString();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();             
            SecurityUtils.getSubject().login(token);
            String menu = roleService.createRoute(username);
      	    Map<String,String> userMap = new HashMap<String, String>();
     	    
      	    userMap.put("token", String.valueOf(currentUser.getSession().getId()));
      	    userMap.put("menu", menu);
      	   
      	   
      	   Map<String,Object> m = new HashMap<String, Object>();
      	   m.put("user", userMap);
      	   m.put("msg", "success");
      	   return m;

        } catch (UnknownAccountException e) {
        	Map<String,Object> m = new HashMap<String, Object>();
        	m.put("msg", "error");
        	m.put("count", "此账号不存在");
        	return m;
        }catch (IncorrectCredentialsException e) {
        	Map<String,Object> m = new HashMap<String, Object>();
        	m.put("msg", "error");
        	m.put("count", "密码不正确");
        	return m;
        }catch (LockedAccountException e) {
        	Map<String,Object> m = new HashMap<String, Object>();
        	m.put("msg", "error");
        	m.put("count", "账号已冻结");
        	return m;
        }
     
    }

    /**
     * ajax登录请求接口方式登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/createRoute",method= RequestMethod.POST)
    @ResponseBody
    public List<Role> createRoute(String name) {
    	List<Role> uuu = roleService.createRoute2(name);
        return uuu;
     
    }


	           
	        

	           
}
