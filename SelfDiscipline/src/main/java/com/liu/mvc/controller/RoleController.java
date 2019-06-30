package com.liu.mvc.controller;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.service.IRoleService;


@Controller
@CrossOrigin
@RequestMapping(value="/role")
public class RoleController {
			@Autowired	
			private IRoleService roleService;
	
			@RequestMapping(value="/getRoleList")
			@ResponseBody
			public List<Role> getUserList(@RequestBody Map<String,Object> map){				
				String uname = map.get("rolename").toString();		
				List<Role> roleList = roleService.getRoleList(uname);
				return roleList;
			}
			
		
}
