package com.liu.mvc.service;

import java.util.List;

import com.liu.mvc.pojo.Diary;

public interface IDiaryService {
          
	        List<Diary> selectDiary(String id);
	        int insertDiary(Diary d);
	        int updateDiary(Diary d);
	        int deleteDiary(String d);
	        
	        
	        
}
