package com.liu.mvc.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.liu.mvc.dao.role.RoleMapper;
import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IRoleService;
import com.liu.mvc.service.IUserService;

@Service
public class RoleServiceImpl implements IRoleService{
	
	@Resource
	public RoleMapper roleDao;

	@Override
	public List<Role> getRoleList(String u) {
		// TODO Auto-generated method stub
		return roleDao.getRoleList(u);
	}

	

}
