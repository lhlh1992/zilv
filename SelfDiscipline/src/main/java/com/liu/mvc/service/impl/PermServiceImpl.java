package com.liu.mvc.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.liu.mvc.dao.perm.PermMapper;
import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Perm;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IPermService;
import com.liu.mvc.service.IUserService;

@Service
public class PermServiceImpl implements IPermService{
	
	@Resource
	public PermMapper permDao;

	@Override
	public List<Perm> getPermList(String u) {
		// TODO Auto-generated method stub
		return permDao.getPermList(u);
	}

	

}
