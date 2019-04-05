package com.liu.mvc.dao.diary;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import com.liu.mvc.pojo.Diary;

public interface DiaryMapper {
         
	        List<Diary> selectDiary(@Param("id")  String id);
	                     
	        int insertDiary(Diary d);
	        
	        int updateDiary(Diary d);
	        
	        int deleteDiary(String d);
	    
}
