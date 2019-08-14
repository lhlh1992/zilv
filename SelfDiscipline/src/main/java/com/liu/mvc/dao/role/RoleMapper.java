package com.liu.mvc.dao.role;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.liu.mvc.pojo.Role;



public interface RoleMapper {
			
	  List<Role> getRoleList(@Param("rolename") String u);
	 
	  List<Role> createRoute(@Param("username") String u);
	 
	  public int addRole(Role role);
	 
	  public  int editRole(Role role);
	  
	  public  Role getRole(Role u);
	  
	  public int deleteRole(@Param("rid")int rid);
	  
	  public int deleteUserRole(@Param("rid")String  rid);
	  
	  public int deleteRolePrem(@Param("rid")String  rid);
}

