package com.liu.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liu.mvc.pojo.Diary;
import com.liu.mvc.service.IDiaryService;
import com.liu.mvc.utils.DateUtils;

@Controller
@CrossOrigin
@RequestMapping(value="/Diary")
public class diaryController {
               
	          @Autowired
	          public IDiaryService  iDiaryService;
	          
	          @RequestMapping(value="/selectDiary")
	          @ResponseBody
	          public List<Diary> selectDiary(@RequestBody  Map<String,Object> map) { 
	        	  System.out.println();
	        	  String id = map.get("id").toString();
	        	  return iDiaryService.selectDiary(id);       			 	  
	          }
	          
	          @RequestMapping(value="/addDiary")
	          @ResponseBody
	          public int addDiary(@RequestBody  Map<String,Object> map) {   
	        	  Diary diary = new Diary();
	        	  List<Map<String,String>> sportsContent = new ArrayList<>();   //健身内容集合  	 
	        	  String studyTime="";//学习所用时间
	        	  String sportsTime="";//健身所用时间
	        	  String aijiuTime="";//艾灸所用时间
	        	  List<String> spList = (List)map.get("nameList");
	        	  List<String> numList = (List)map.get("numList");                	 
	        	  int z=0;
	        	  for(int i=0;i<spList.size();i++) {
	        		   Map<String,String> m = new HashMap<>();      		  
	        		   for(int j = 0;j<numList.size();j++) {
	        			    m.put(spList.get(i), numList.get(z).replace("分钟", " "));
	        			    z++;
	        			    break;
	        		   }
	        		   sportsContent.add(m);   		  
	        	  }        	  
	        	  String studyTimeStart = map.get("studyTimeStart").toString();
	        	  String studyTimeEnd = map.get("studyTimeEnd").toString();
	        	  if(studyTimeStart!="" && studyTimeEnd!="") {
	        		  studyTime = DateUtils.gettimeDifference(studyTimeStart,studyTimeEnd);
	        		  diary.setStudyTimeStart(studyTimeStart);
	        		  diary.setStudyTimeEnd(studyTimeEnd);
	        	  }
	        	         	  
	        	  String jsTimeStart = map.get("jsTimeStart").toString();
	        	  String jsTimeEnd = map.get("jsTimeEnd").toString();
	        	  if(jsTimeStart!="" && jsTimeEnd!="") {
	        		  sportsTime = DateUtils.gettimeDifference(jsTimeStart,jsTimeEnd);
	        		  diary.setSportsTimeStart(jsTimeStart);
	        		  diary.setSportsTimeEnd(jsTimeEnd);
	        	  }
	              	  
	        	  String ajTimeStart = map.get("ajTimeStart").toString();
	        	  String ajTimeEnd = map.get("ajTimeEnd").toString();
	        	  if(ajTimeStart!="" && ajTimeEnd!="") {
	        		  aijiuTime = DateUtils.gettimeDifference(ajTimeStart,ajTimeEnd);
	        		  diary.setAijiuTimeStart(ajTimeStart);
	        		  diary.setAijiuTimeEnd(ajTimeEnd);
	        	  }
	        	  String aa =map.get("dinner").toString();
	        	  String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	        	  diary.setId(uuid);//Id
	        	  diary.setSportsContent(sportsContent.toString());//运动项目
	        	  diary.setStudyContent(map.get("studyContent").toString());//学习内容
	        	  diary.setDinner(map.get("dinner").toString());//今日饮食
	        	  diary.setBadHabits(map.get("BadHabits").toString());//是否戒色
	        	  diary.setSleepTime(map.get("sleepTime").toString());//晚上睡觉时间
	        	  diary.setHealthStatus(map.get("healthStatus").toString());//健康状态(是否尿床)
	        	  diary.setAppetite(map.get("appetite").toString());//是否吃宵夜，控制饮食
	        	  diary.setFaceWash(map.get("faceWash").toString());//是否洗脸
	        	  diary.setBrushTooth(map.get("brushTooth").toString());//是否刷牙
	        	  diary.setStudyTime(studyTime);//学习所用时间
	        	  diary.setSportsTime(sportsTime);//健身所用时间
	        	  diary.setAijiuTime(aijiuTime);//艾灸所用时间
	        	  diary.setSentiment(map.get("sentiment").toString());//心情日记
	        	  diary.setCreate_time(map.get("create_time").toString());	        	  	               	    	  
	        	  return iDiaryService.insertDiary(diary);       			 	  
	          }
	          
	          
	          @RequestMapping(value="/editDiary")
	          @ResponseBody
	          public int editDiary(@RequestBody  Map<String,Object> map) {   
	        	  Diary diary = new Diary();
	        	  System.out.println(map);
	        	  List<Map<String,String>> sportsContent = new ArrayList<>();   //健身内容集合  	 
	        	  String studyTime="";//学习所用时间
	        	  String sportsTime="";//健身所用时间
	        	  String aijiuTime="";//艾灸所用时间
	        	  List<String> spList = (List)map.get("nameList");
	        	  List<String> numList = (List)map.get("numList");                	 
	        	  int z=0;
	        	  for(int i=0;i<spList.size();i++) {
	        		   Map<String,String> m = new HashMap<>();	        		  
	        		   for(int j = 0;j<numList.size();j++) {
	        			    m.put(spList.get(i), numList.get(z).replace("分钟", " "));
	        			    z++;
	        			    break;
	        		   }
	        		   sportsContent.add(m);   		  
	        	  }
	        	  
	        	  String studyTimeStart = map.get("studyTimeStart").toString();
	        	  String studyTimeEnd = map.get("studyTimeEnd").toString();
	        	  if(studyTimeStart!="" && studyTimeEnd!="") {
	        		  studyTime = DateUtils.gettimeDifference(studyTimeStart,studyTimeEnd);
	        		  diary.setStudyTimeStart(studyTimeStart);
	        		  diary.setStudyTimeEnd(studyTimeEnd);
	        	  }
	        	         	  
	        	  String jsTimeStart = map.get("jsTimeStart").toString();
	        	  String jsTimeEnd = map.get("jsTimeEnd").toString();
	        	  if(jsTimeStart!="" && jsTimeEnd!="") {
	        		  sportsTime = DateUtils.gettimeDifference(jsTimeStart,jsTimeEnd);
	        		  diary.setSportsTimeStart(jsTimeStart);
	        		  diary.setSportsTimeEnd(jsTimeEnd);
	        	  }
	              	  
	        	  String ajTimeStart = map.get("ajTimeStart").toString();
	        	  String ajTimeEnd = map.get("ajTimeEnd").toString();
	        	  if(ajTimeStart!="" && ajTimeEnd!="") {
	        		  aijiuTime = DateUtils.gettimeDifference(ajTimeStart,ajTimeEnd);
	        		  diary.setAijiuTimeStart(ajTimeStart);
	        		  diary.setAijiuTimeEnd(ajTimeEnd);
	        	  }
	        	  String aa =map.get("dinner").toString();
	        
	        	
	        	  diary.setId(map.get("id").toString());
	        	  diary.setSportsContent(sportsContent.toString());//运动项目
	        	  diary.setStudyContent(map.get("studyContent").toString());//学习内容
	        	  diary.setDinner(map.get("dinner").toString());//今日饮食
	        	  diary.setBadHabits(map.get("BadHabits").toString());//是否戒色
	        	  diary.setSleepTime(map.get("sleepTime").toString());//晚上睡觉时间
	        	  diary.setHealthStatus(map.get("healthStatus").toString());//健康状态(是否尿床)
	        	  diary.setAppetite(map.get("appetite").toString());//是否吃宵夜，控制饮食
	        	  diary.setFaceWash(map.get("faceWash").toString());//是否洗脸
	        	  diary.setBrushTooth(map.get("brushTooth").toString());//是否刷牙
	        	  diary.setStudyTime(studyTime);//学习所用时间
	        	  diary.setSportsTime(sportsTime);//健身所用时间
	        	  diary.setAijiuTime(aijiuTime);//艾灸所用时间
	        	  diary.setSentiment(map.get("sentiment").toString());//心情日记	  
	        	  return iDiaryService.updateDiary(diary);       			 	  
	          }
	          
	          
	          @RequestMapping(value="/delDiary")
	          @ResponseBody
	          public int delDiary(@RequestBody  Map<String,Object> map) {
	        	  	String id = map.get("id").toString();
	        	  	return iDiaryService.deleteDiary(id);
	          }
	  
	          
}
