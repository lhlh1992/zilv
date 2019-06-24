package com.liu.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liu.mvc.dao.classInfo.classInfoMapper;
import com.liu.mvc.dao.user.userMapper;
import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.User;
import com.liu.mvc.pojo.classInfo;
import com.liu.mvc.service.IDicitemService;
import com.liu.mvc.service.IDictypeService;



import com.liu.redis.redisUtils.RedisUtil;




@Controller
@CrossOrigin
@RequestMapping(value="/test")
public class testController {
	

	   
	@Autowired
	private IDictypeService dictypeService;
	
	@Autowired
	private IDicitemService dicitemService;
	
	@Autowired
	private classInfoMapper classInfoMapper;
	
	@Autowired
	private userMapper userMapper;
	
	
	@Autowired
	private RedisUtil RedisUtil;
	        
	        
	           
	           
	           @RequestMapping(value="/redisSet")
	           @ResponseBody        
	              public  void redisSet(@RequestBody String key) {
	        	  
	        	   RedisUtil.set(key, "oooo");
	              }
	           
	           @RequestMapping(value="/redisfind")
	           @ResponseBody        
	              public boolean  redisfind(@RequestBody String key) {
	        	   

	        	    boolean b = RedisUtil.exists(key);
	        	    return b;
	              }
	           
	           /**
	            * mybatis一对多映射测试
	            * @param id
	            * @return
	            */
	           @RequestMapping(value="/classInfo")
	           @ResponseBody
	           public List<classInfo> queryClassInfo(@RequestBody String id){
	        	   System.out.println("pppppppp");
	        	   List<classInfo> l= classInfoMapper.queryClassInfo(id);
	        	   
	        	   return l;
	           }
	        
	           
	           /**
	            * mybatis一对多映射测试
	            * @param id
	            * @return
	            */
	           @RequestMapping(value="/test")
	           @ResponseBody
	           public Map<String,String> test(@RequestBody Map<String,String> name){
	        	   System.out.println(name.get("name"));
	        	   
	        	   	return name;
	           }
	           
	           
	           
	           /**
	            * mybatis一对多映射测试
	            * @param id
	            * @return
	            */
	           @RequestMapping(value="/login")
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
