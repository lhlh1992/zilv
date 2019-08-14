package com.liu.mvc.controller;


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
import com.liu.mvc.service.IRoleService;


@Controller
@CrossOrigin
@RequestMapping(value="/role")
public class RoleController {
			@Autowired	
			private IRoleService roleService;
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("角色列表查看")
			@RequestMapping(value="/getRoleList")
			@ResponseBody
			public List<Role> getUserList(@RequestBody Map<String,Object> map){				
				String uname = map.get("rolename").toString();		
				List<Role> roleList = roleService.getRoleList(uname);
				return roleList;
			}
			
			
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("角色新增")
			@RequestMapping(value="/addRole")
			@ResponseBody
			public int addRole(@RequestBody Map<String,Object> map){				
				String rolename = map.get("rolename").toString();	
				String roleCode = map.get("roleCode").toString();
				String description = map.get("description").toString();
				Role r = new Role();
				r.setRoleCode(roleCode);
				r.setRolename(rolename);
				r.setDescription(description);
				
				return roleService.addRole(r);
			}
			
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("角色修改")
			@RequestMapping(value="/editRole")
			@ResponseBody
			public int editRole(@RequestBody Map<String,Object> map){				
 				String rolename = map.get("rolename").toString();	
				String roleCode = map.get("roleCode").toString();
				String description = map.get("description").toString();
				String available = map.get("available").toString();
				String rid = map.get("rid").toString();
				Role r = new Role();
				r.setRoleCode(roleCode);
				r.setRolename(rolename);
				r.setDescription(description);
				r.setAvailable(Boolean.parseBoolean(available));
				r.setRid(Integer.valueOf(rid));
				return roleService.editRole(r);
			}
			
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("角色禁用")
			@RequestMapping(value="/BanRole")
			@ResponseBody
			public Role BanRole(@RequestBody Map<String,Object> map){				
				Role u=new Role();				
				u.setRid(Integer.valueOf(map.get("rid").toString()));
				Role role = roleService.banRole(u);			
				return role;
			}
			
			
			@RequiresRoles("超级管理员")
			@RequiresPermissions("角色删除")
			@RequestMapping(value="/deleteRole")
			@ResponseBody
			public int deleteRole(String rid){		
				int count= roleService.deleteRole(rid);		
				return count;
			}
			
		
}
