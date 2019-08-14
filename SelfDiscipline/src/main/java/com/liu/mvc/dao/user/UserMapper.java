package com.liu.mvc.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.liu.mvc.pojo.User;



public interface UserMapper {
			 
		   public  User getUser(User u);
	       
	       public  List<User> getUserList(@Param("username") String u);
	       	       
	       public  int addUser(User u);
	       
	       public  int editUser(User u);
	       
	       public  int deleteUser(@Param("uid")String id);
	       
	       public  int deleteUserRole(@Param("uid")String id);
	       
}
