package com.liu.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.mvc.dao.user.userMapper;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Resource
	public userMapper userDao;

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return userDao.getUser(u);
	}

}
