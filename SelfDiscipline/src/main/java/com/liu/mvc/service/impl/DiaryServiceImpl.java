package com.liu.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.mvc.dao.diary.DiaryMapper;
import com.liu.mvc.pojo.Diary;
import com.liu.mvc.service.IDiaryService;
@Service
public class DiaryServiceImpl implements IDiaryService{
	
	
	
	@Resource
	public DiaryMapper  diaryMapper;

	@Override
	public List<Diary> selectDiary() {
		// TODO Auto-generated method stub
		return diaryMapper.selectDiary();
	}

	

}
