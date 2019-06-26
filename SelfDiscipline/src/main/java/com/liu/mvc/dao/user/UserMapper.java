package com.liu.mvc.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.mvc.pojo.User;



public interface UserMapper {
			 
	       User getUser(User u);
	       
	       List<User> getUserList(@Param("username") String u);
	       
	       
	       int addUser(User u);
}
