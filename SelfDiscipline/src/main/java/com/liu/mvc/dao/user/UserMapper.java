package com.liu.mvc.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.liu.mvc.pojo.User;



public interface UserMapper {
			 
	       User getUser(User u);
	       
	       List<User> getUserList(@Param("username") String u);
	       	       
	       int addUser(User u);
	       
	       int editUser(User u);
	       
	       int deleteUser(@Param("uid")String id);
	       
}
