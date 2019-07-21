package com.liu.mvc.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.liu.mvc.dao.user.UserMapper;
import com.liu.mvc.pojo.Role;
import com.liu.mvc.pojo.User;
import com.liu.mvc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Resource
	public UserMapper userDao;

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return userDao.getUser(u);
	}

	@Override
	public List<User> getUserList(String uname) {
		// TODO Auto-generated method stub
		List<User> userList =  userDao.getUserList(uname);
		for(User u:userList) {
			List<Role> rlist = u.getRoleList();
			//处理角色显示
			String str="";
			for(Role r:rlist) {
				 str=str+r.getRolename()+",";
			}
			str=str.substring(0, str.length()-1);
			if(str.length()>13) {
					str=str.substring(0, 13)+"...";
			}
			u.setRoleStr(str);
			//处理状态字段
			if(u.getIs_Banning().equals("1")) {
				u.setIs_Banning("已启用");
			}else {
				u.setIs_Banning("禁用中");
			}
			
	}
		return userList;
	}

	@Override
	public int addUser(User u) {
		String id = UUID.randomUUID().toString().replaceAll("-", "");    //UUID
		String salt = UUID.randomUUID().toString().replaceAll("-", "");  //随机盐值
		String username=u.getUsername();
		String password=u.getPassword();
		String hashAlgorithmName = "MD5";//加密方式
		int hashIterations = 1024;//加密1024次
		String unsalt = username+salt;   //盐值处理成用户名+盐值，有利于数据的安全
		//加密加盐后的MD5密码
		Object result = new SimpleHash(hashAlgorithmName,password,unsalt,hashIterations);
		u.setUid(id);
		u.setUsername(username);
		u.setPassword(result.toString());
		u.setSalt(salt);
		return userDao.addUser(u);
	}

	

}
