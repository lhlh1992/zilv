package com.liu.mvc.dao.perm;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.mvc.pojo.Perm;


public interface PermMapper {
			
	 List<Perm> getPermList(@Param("permissionName") String u,@Param("peid")String id);
}
