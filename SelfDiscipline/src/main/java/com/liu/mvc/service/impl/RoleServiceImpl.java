package com.liu.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.mvc.dao.role.RoleMapper;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.service.IRoleService;



@Service
public class RoleServiceImpl   implements IRoleService {
   
	  @Resource
	    private RoleMapper role;

		public List<Role> selectRoles(String str) {
		   List<Role>  rList = 	role.selectRoles(str);
			return rList;
		}
}
