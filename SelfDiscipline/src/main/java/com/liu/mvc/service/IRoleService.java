package com.liu.mvc.service;

import java.util.List;
import java.util.Map;

import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;


public interface IRoleService {
				
	     
	         
	         public List<Role> getRoleList(String u);
	         
	         
	         public String createRoute(String u);
	         
	         public List<Role> createRoute2(String u);
	         
	         
	         public int addRole(Role role);
	         
	         public int editRole(Role role);
	         
	         public Role banRole(Role role);
	         
	         
	         public int deleteRole(String id);
	         
	   
	
}
