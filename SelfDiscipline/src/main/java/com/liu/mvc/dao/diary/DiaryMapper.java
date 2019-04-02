package com.liu.mvc.dao.diary;

import java.util.List;

import com.liu.mvc.pojo.Diary;

public interface DiaryMapper {
         
	        List<Diary> selectDiary();
	                     
	        int insertDiary(Diary d);
	    
}
