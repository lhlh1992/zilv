package com.liu.mvc.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IUserService;

@Controller
@CrossOrigin
@RequestMapping(value="/user")
public class UserController {
			@Autowired	
			private IUserService userService;
			
		
			@RequiresPermissions("用户管理列表查看")
			@RequestMapping(value="/getUserList")
			@ResponseBody
			public List<User> getUserList(@RequestBody Map<String,Object> map){				
				String uname = map.get("username").toString();		
				List<User> userList = userService.getUserList(uname);
				return userList;
			}
			
			@RequestMapping(value="/addUser")
			@ResponseBody
			public int addUser(User u){				
				
				int i = userService.addUser(u);
				
				return i;
			}
}
