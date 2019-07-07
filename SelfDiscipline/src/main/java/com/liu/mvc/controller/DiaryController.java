package com.liu.mvc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liu.mvc.pojo.Diary;
import com.liu.mvc.pojo.excelPoi;
import com.liu.mvc.service.IDiaryService;
import com.liu.mvc.utils.DateUtils;
import com.liu.mvc.utils.PoiUtils;
import com.sun.tools.javac.util.Log;

@Controller
@CrossOrigin
@RequestMapping(value = "/Diary")
public class DiaryController {

	@Autowired
	public IDiaryService iDiaryService;

	@RequestMapping(value = "/selectDiary")
	@ResponseBody
	public List<Diary> selectDiary(@RequestBody Map<String, Object> map) {
		System.out.println();
		String id = map.get("id").toString();
		return iDiaryService.selectDiary(id);
	}

	@RequestMapping(value = "/addDiary")
	@ResponseBody
	public int addDiary(@RequestBody Map<String, Object> map) {
		Diary diary = new Diary();
		List<Map<String, String>> sportsContent = new ArrayList<>(); // 健身内容集合
		String studyTime = "";// 学习所用时间
		String sportsTime = "";// 健身所用时间
		String aijiuTime = "";// 艾灸所用时间
		List<String> spList = (List) map.get("nameList");
		List<String> numList = (List) map.get("numList");
		int z = 0;
		for (int i = 0; i < spList.size(); i++) {
			Map<String, String> m = new HashMap<>();
			for (int j = 0; j < numList.size(); j++) {
				m.put(spList.get(i), numList.get(z).replace("分钟", " "));
				z++;
				break;
			}
			sportsContent.add(m);
		}
		String studyTimeStart = map.get("studyTimeStart").toString();
		String studyTimeEnd = map.get("studyTimeEnd").toString();
		if (studyTimeStart != null && studyTimeEnd != null) {
			studyTime = DateUtils.gettimeDifference(studyTimeStart, studyTimeEnd);
			diary.setStudyTimeStart(studyTimeStart);
			diary.setStudyTimeEnd(studyTimeEnd);
		}

		String jsTimeStart = map.get("jsTimeStart").toString();
		String jsTimeEnd = map.get("jsTimeEnd").toString();
		if (jsTimeStart != null && jsTimeEnd != null) {
			sportsTime = DateUtils.gettimeDifference(jsTimeStart, jsTimeEnd);
			diary.setSportsTimeStart(jsTimeStart);
			diary.setSportsTimeEnd(jsTimeEnd);
		}

		String ajTimeStart = map.get("ajTimeStart").toString();
		String ajTimeEnd = map.get("ajTimeEnd").toString();
		if (ajTimeStart != null && ajTimeEnd != null) {
			aijiuTime = DateUtils.gettimeDifference(ajTimeStart, ajTimeEnd);
			diary.setAijiuTimeStart(ajTimeStart);
			diary.setAijiuTimeEnd(ajTimeEnd);
		}
		String aa = map.get("dinner").toString();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		diary.setId(uuid);// Id
		diary.setSportsContent(sportsContent.toString());// 运动项目
		diary.setStudyContent(map.get("studyContent").toString());// 学习内容
		diary.setDinner(map.get("dinner").toString());// 今日饮食
		diary.setBadHabits(map.get("BadHabits").toString());// 是否戒色
		diary.setSleepTime(map.get("sleepTime").toString());// 晚上睡觉时间
		diary.setHealthStatus(map.get("healthStatus").toString());// 健康状态(是否尿床)
		diary.setAppetite(map.get("appetite").toString());// 是否吃宵夜，控制饮食
		diary.setFaceWash(map.get("faceWash").toString());// 是否洗脸
		diary.setBrushTooth(map.get("brushTooth").toString());// 是否刷牙
		diary.setStudyTime(studyTime);// 学习所用时间
		diary.setSportsTime(sportsTime);// 健身所用时间
		diary.setAijiuTime(aijiuTime);// 艾灸所用时间
		diary.setSentiment(map.get("sentiment").toString());// 心情日记
		diary.setCreate_time(map.get("create_time").toString());
		return iDiaryService.insertDiary(diary);
	}

	@RequestMapping(value = "/editDiary")
	@ResponseBody
	public int editDiary(@RequestBody Map<String, Object> map) {
		Diary diary = new Diary();
		System.out.println(map);
		List<Map<String, String>> sportsContent = new ArrayList<>(); // 健身内容集合
		String studyTime = "";// 学习所用时间
		String sportsTime = "";// 健身所用时间
		String aijiuTime = "";// 艾灸所用时间
		List<String> spList = (List) map.get("nameList");
		List<String> numList = (List) map.get("numList");
		int z = 0;
		for (int i = 0; i < spList.size(); i++) {
			Map<String, String> m = new HashMap<>();
			for (int j = 0; j < numList.size(); j++) {
				m.put(spList.get(i), numList.get(z).replace("分钟", " "));
				z++;
				break;
			}
			sportsContent.add(m);
		}

		String studyTimeStart = map.get("studyTimeStart").toString();
		String studyTimeEnd = map.get("studyTimeEnd").toString();
		if (studyTimeStart != "" && studyTimeEnd != "") {
			studyTime = DateUtils.gettimeDifference(studyTimeStart, studyTimeEnd);
			diary.setStudyTimeStart(studyTimeStart);
			diary.setStudyTimeEnd(studyTimeEnd);
		}

		String jsTimeStart = map.get("jsTimeStart").toString();
		String jsTimeEnd = map.get("jsTimeEnd").toString();
		if (jsTimeStart != "" && jsTimeEnd != "") {
			sportsTime = DateUtils.gettimeDifference(jsTimeStart, jsTimeEnd);
			diary.setSportsTimeStart(jsTimeStart);
			diary.setSportsTimeEnd(jsTimeEnd);
		}

		String ajTimeStart = map.get("ajTimeStart").toString();
		String ajTimeEnd = map.get("ajTimeEnd").toString();
		if (ajTimeStart != "" && ajTimeEnd != "") {
			aijiuTime = DateUtils.gettimeDifference(ajTimeStart, ajTimeEnd);
			diary.setAijiuTimeStart(ajTimeStart);
			diary.setAijiuTimeEnd(ajTimeEnd);
		}
		String aa = map.get("dinner").toString();

		diary.setId(map.get("id").toString());
		diary.setSportsContent(sportsContent.toString());// 运动项目
		diary.setStudyContent(map.get("studyContent").toString());// 学习内容
		diary.setDinner(map.get("dinner").toString());// 今日饮食
		diary.setBadHabits(map.get("BadHabits").toString());// 是否戒色
		diary.setSleepTime(map.get("sleepTime").toString());// 晚上睡觉时间
		diary.setHealthStatus(map.get("healthStatus").toString());// 健康状态(是否尿床)
		diary.setAppetite(map.get("appetite").toString());// 是否吃宵夜，控制饮食
		diary.setFaceWash(map.get("faceWash").toString());// 是否洗脸
		diary.setBrushTooth(map.get("brushTooth").toString());// 是否刷牙
		diary.setStudyTime(studyTime);// 学习所用时间
		diary.setSportsTime(sportsTime);// 健身所用时间
		diary.setAijiuTime(aijiuTime);// 艾灸所用时间
		diary.setSentiment(map.get("sentiment").toString());// 心情日记
		return iDiaryService.updateDiary(diary);
	}

	@RequestMapping(value = "/delDiary")
	@ResponseBody
	public int delDiary(@RequestBody Map<String, Object> map) {
		String id = map.get("id").toString();
		return iDiaryService.deleteDiary(id);
	}

	@RequestMapping(value = "/downExcel")
	public void download(@RequestBody Map<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) {
//	        		String json = map.get("diary").toString();
//	        		Map m=(Map)JSON.parse(json); 

		String id = map.get("id").toString();
		List<Diary> diary = iDiaryService.selectDiary(id);

		excelPoi poi = new excelPoi();

		List<String> title = new ArrayList<>();
		title.add("日期");
		title.add("学习时间");
		title.add("学习内容");
		title.add("健身时间");
		title.add("健身内容");
		title.add("日记");
		poi.setTitle(title);

		List<List<String>> data = new ArrayList<>();

		for (Diary d : diary) {
			List<String> l = new ArrayList<>();
			l.add(d.getCreate_time());
			l.add(d.getStudyTime());
			l.add(d.getStudyContent());
			l.add(d.getSportsTime());
			l.add(d.getSportsContent());
			l.add(d.getSentiment());
			data.add(l);
		}
		poi.setData(data);
		poi.setTabName("日记");

		int rowIndex = 0;
//	        		try{
//	                    rowIndex = ExcelUtil.generateExcel(poi, "F:\\微信\\" +"aaa.xls");
//	                }catch (Exception e){
//	                    e.printStackTrace();
//	                }

		HSSFWorkbook wb = PoiUtils.getHSSFWrokbook("aa", poi);

		try {
			this.setResponseHeader(response, "aaa.xsl");
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 发送响应流方法
	public void setResponseHeader(HttpServletResponse response, String fileName) {
		try {
			try {
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
