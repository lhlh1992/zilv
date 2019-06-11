package com.liu.mvc.dao.classInfo;

import java.util.List;

import com.liu.mvc.pojo.Diary;
import com.liu.mvc.pojo.classInfo;

import org.apache.ibatis.annotations.Param;

public interface classInfoMapper {
			
				List<classInfo> queryClassInfo(@Param("id") String id);
				
				
}
