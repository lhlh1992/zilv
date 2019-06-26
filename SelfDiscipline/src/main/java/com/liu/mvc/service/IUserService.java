package com.liu.mvc.service;

import java.util.List;

import com.liu.mvc.pojo.User;

public interface IUserService {
				
	         public User getUser(User u);
	         
	         public List<User> getUserList(String u);
	         
	         
	         public int addUser(User u);

	
}
