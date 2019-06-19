package com.liu.mvc.controller;

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
import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.classInfo;
import com.liu.mvc.service.IDicitemService;
import com.liu.mvc.service.IDictypeService;
import com.liu.mvc.service.IRoleService;


import com.liu.redis.redisUtils.RedisUtil;




@Controller
@CrossOrigin
public class loginController {
	
	@Autowired
	private IRoleService roleService;
	   
	@Autowired
	private IDictypeService dictypeService;
	
	@Autowired
	private IDicitemService dicitemService;
	
	@Autowired
	private classInfoMapper classInfoMapper;
	
	
	@Autowired
	private RedisUtil RedisUtil;
	        
	           @RequestMapping(value="/roleList")
	           @ResponseBody        
	              public  List<Role> roleList() {
		        	List<Role> list =   roleService.selectRoles("");
		        	return list;
	              }
	           
	           
	           
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
	        
	           
	        

	           
}
