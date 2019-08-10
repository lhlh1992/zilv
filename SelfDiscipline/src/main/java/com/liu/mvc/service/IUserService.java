package com.liu.mvc.service;

import java.util.List;
import java.util.Map;

import com.liu.mvc.pojo.User;

public interface IUserService {
				
	         public User getUser(User u);
	         
	         public List<User> getUserList(String u);
	         
	         
	         public int addUser(User u);
	         
	         public int editUser(User u);
	         
	         public User banUser(User u);
	         
	         
	         public int deleteUser(String id);
}
