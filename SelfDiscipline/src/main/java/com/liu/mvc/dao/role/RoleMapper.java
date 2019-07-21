package com.liu.mvc.dao.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liu.mvc.pojo.Role;


public interface RoleMapper {
			
	 List<Role> getRoleList(@Param("rolename") String u);
	 
	 List<Role> createRoute(@Param("username") String u);

}
