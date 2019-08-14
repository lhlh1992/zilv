package com.liu.mvc.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
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
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("用户管理列表")
			@RequestMapping(value="/getUserList")
			@ResponseBody
			public List<User> getUserList(@RequestBody Map<String,Object> map){				
				String uname = map.get("username").toString();		
				List<User> userList = userService.getUserList(uname);
				return userList;
			}
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("用户添加")
			@RequestMapping(value="/addUser")
			@ResponseBody
			public int addUser(@RequestBody Map<String,Object> map){				
				User u=new User();		
				u.setUsername(map.get("username").toString());
				u.setPassword(map.get("password").toString());
				int i = userService.addUser(u);			
				return i;
			}
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("用户修改")
			@RequestMapping(value="/editUser")
			@ResponseBody
			public int editUser(@RequestBody Map<String,Object> map){				
				User u=new User();				
				u.setUsername(map.get("username").toString());
				u.setPassword(map.get("password").toString());
				u.setBanning(Boolean.parseBoolean(map.get("Banning").toString()));
				u.setUid(map.get("uid").toString());
				int i = userService.editUser(u);			
				return i;
			}
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("用户禁用")
			@RequestMapping(value="/BanUser")
			@ResponseBody
			public User BanUser(@RequestBody Map<String,Object> map){				
				User u=new User();				
				u.setUid(map.get("uid").toString());
				User user = userService.banUser(u);			
				return user;
			}
			
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("用户删除")
			@RequestMapping(value="/deleteUser")
			@ResponseBody
			public int deleteUser(String uid){		
				System.out.println(uid);
				int user= userService.deleteUser(uid);		
				return user;
			}
}
