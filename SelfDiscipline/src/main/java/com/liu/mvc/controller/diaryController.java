package com.liu.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.pojo.Diary;
import com.liu.mvc.service.IDiaryService;

@Controller
@CrossOrigin
@RequestMapping(value="/Diary")
public class diaryController {
               
	          @Autowired
	          public IDiaryService  iDiaryService;
	          
	          @RequestMapping(value="/selectDiary")
	          @ResponseBody
	          public List<Diary> selectDiary() {      	 
	        	  return iDiaryService.selectDiary();       			 	  
	          }
}
