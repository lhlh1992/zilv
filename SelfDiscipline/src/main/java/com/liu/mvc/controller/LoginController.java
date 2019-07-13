package com.liu.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
import com.liu.mvc.pojo.User;

@Controller
@CrossOrigin
public class LoginController {
	@Autowired
	private UserMapper userMapper;

	   		

    /**
     * ajax登录请求接口方式登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(@RequestBody Map<String,String> json,ServletRequest request) {
    	
    	 HttpServletRequest req = (HttpServletRequest) request;
    	 String authorization = req.getHeader("Authorization");
    	 System.out.println(authorization);
    	 
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String username = json.get("username").toString();
  	    String password = json.get("password").toString();
        try {

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();             
            SecurityUtils.getSubject().login(token);
            
       
           Date d = new Date();
      	   SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
      	   String time = s.format(d);
      	   Map<String,String> userMap = new HashMap<String, String>();
      	   
      	   userMap.put("token", String.valueOf(currentUser.getSession().getId()));
      	   userMap.put("name", username);
      	   userMap.put("email", username+"qq@.com");
      	   userMap.put("id", "10000");
      	   userMap.put("time", time);
      	   Map<String,Object> m = new HashMap<String, Object>();
      	   m.put("user", userMap);
      	   m.put("msg", "success");
      	   return m;

        } catch (UnknownAccountException e) {
        	Map<String,Object> m = new HashMap<String, Object>();
        	m.put("msg", "error");
        	m.put("count", "此账号不存在");
        	return m;
//            resultMap.put("status", 500);
//            resultMap.put("message", e.getMessage());
//            resultMap.put("count", "不存在的账号");
        }catch (IncorrectCredentialsException e) {
        	Map<String,Object> m = new HashMap<String, Object>();
        	m.put("msg", "error");
        	m.put("count", "密码不正确");
        	return m;
//            resultMap.put("status", 500);
//            resultMap.put("message", e.getMessage());
//            resultMap.put("count", "账号存在但是密码错误");
        }
     
    }

    
    
    /**
     * mybatis一对多映射测试
     * @param id
     * @return
     */
    @RequestMapping(value="/login1")
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String,String> json){
 	   String username = json.get("userName").toString();
 	   String password = json.get("password").toString();
 	   User user=new User();
 	   
 	   user.setPassword(password);
 	   user.setUsername(username);
 	   User u = userMapper.getUser(user);
 	   
 	   Date d = new Date();
 	   SimpleDateFormat s = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
 	   String time = s.format(d);
 	   Map<String,String> userMap = new HashMap<String, String>();
 	   userMap.put("token", "123456789");
 	   userMap.put("name", username);
 	   userMap.put("email", username+"qq@.com");
 	   userMap.put("id", "10000");
 	   userMap.put("time", time);
 	   Map<String,Object> m = new HashMap<String, Object>();
 	   m.put("user", userMap);
 	   m.put("msg", "ok");
 	   return m;
    }
    
	           
	           
	      
	           
	        

	           
}
