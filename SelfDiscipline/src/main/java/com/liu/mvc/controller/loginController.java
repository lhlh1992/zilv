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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.liu.mvc.pojo.DicItem;
import com.liu.mvc.pojo.DicType;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.service.IDicitemService;
import com.liu.mvc.service.IDictypeService;
import com.liu.mvc.service.IRoleService;




@Controller
@CrossOrigin
public class loginController {
	
	@Autowired
	private IRoleService roleService;
	   
	@Autowired
	private IDictypeService dictypeService;
	
	@Autowired
	private IDicitemService dicitemService;
	        
	           @RequestMapping(value="/roleList")
	           @ResponseBody        
	              public  List<Role> roleList() {
		        	List<Role> list =   roleService.selectRoles("");
		        	return list;
	              }
	           
	        
	           
	        

	           
}
