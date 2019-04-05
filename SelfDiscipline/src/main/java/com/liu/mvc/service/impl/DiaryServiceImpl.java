package com.liu.mvc.service.impl;

import java.util.Calendar;
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
	public List<Diary> selectDiary(String id) {
		// TODO Auto-generated method stub
		List<Diary> dLsit = diaryMapper.selectDiary(id);	
		return dLsit;
	}

	@Override
	public int insertDiary(Diary d) {
		// TODO Auto-generated method stub
		return diaryMapper.insertDiary(d);
	}

	@Override
	public int updateDiary(Diary d) {
		// TODO Auto-generated method stub
		return diaryMapper.updateDiary(d);
	}

	@Override
	public int deleteDiary(String d) {
		// TODO Auto-generated method stub
		return diaryMapper.deleteDiary(d);
	}
}
