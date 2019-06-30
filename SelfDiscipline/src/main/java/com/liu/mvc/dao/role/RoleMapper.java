package com.liu.mvc.dao.role;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.liu.mvc.pojo.Role;


public interface RoleMapper {
			
	 List<Role> getRoleList(@Param("rolename") String u);

}
