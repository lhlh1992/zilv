package com.liu.mvc.pojo;

public class Diary {
         
	         private  String id;     
	         private  String studyTime;  //学习时间
	         private  String studyContent;  //学习内容
	         private  String sportsTime;  //健身时间
	         private  String sportsContent;  //健身内容
	         private  String BadHabits;  //是否有不良习惯（0:否  1：是）
	         private  String sleepTime;  //晚上睡觉时间
	         private  String aijiuTime;   //艾灸时间，是否艾灸
	         private  String healthStatus;  //健康状态（字典表）
	         private  String dinner;  //晚餐（字典表获取）
	         private  String appetite;  //是否吃宵夜，控制饮食（0:否 1：是）
	         private  String faceWash;  //是否洗脸(0：否 1：是)
	         private  String brushTooth;  //是否刷牙(0：否 1：是)
	         private  String create_time;  //当日日期
	         private  String sentiment;  //心情感想日记
	         private  String studyTimeStart;//学习开始时间
	         private  String studyTimeEnd;//学习结束时间
	         private  String sportsTimeStart;//健身开始时间
	         private  String sportsTimeEnd;//健身结束时间
	         private  String aijiuTimeStart;//艾灸开始时间
	         private  String aijiuTimeEnd;//艾灸结束时间	         
	         //=========
	         private  int luSum;//坚持不撸的天数   
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getStudyTime() {
				return studyTime;
			}
			public void setStudyTime(String studyTime) {
				this.studyTime = studyTime;
			}
			public String getStudyContent() {
				return studyContent;
			}
			public void setStudyContent(String studyContent) {
				this.studyContent = studyContent;
			}
			public String getSportsTime() {
				return sportsTime;
			}
			public void setSportsTime(String sportsTime) {
				this.sportsTime = sportsTime;
			}
			public String getSportsContent() {
				return sportsContent;
			}
			public void setSportsContent(String sportsContent) {
				this.sportsContent = sportsContent;
			}
			public String getBadHabits() {
				return BadHabits;
			}
			public void setBadHabits(String badHabits) {
				BadHabits = badHabits;
			}
			public String getSleepTime() {
				return sleepTime;
			}
			public void setSleepTime(String sleepTime) {
				this.sleepTime = sleepTime;
			}
			public String getHealthStatus() {
				return healthStatus;
			}
			public void setHealthStatus(String healthStatus) {
				this.healthStatus = healthStatus;
			}
			public String getDinner() {
				return dinner;
			}
			public void setDinner(String dinner) {
				this.dinner = dinner;
			}
			public String getAppetite() {
				return appetite;
			}
			public void setAppetite(String appetite) {
				this.appetite = appetite;
			}
			public String getFaceWash() {
				return faceWash;
			}
			public void setFaceWash(String faceWash) {
				this.faceWash = faceWash;
			}
			public String getBrushTooth() {
				return brushTooth;
			}
			public void setBrushTooth(String brushTooth) {
				this.brushTooth = brushTooth;
			}
			public String getCreate_time() {
				return create_time;
			}
			public void setCreate_time(String create_time) {
				this.create_time = create_time;
			}
			public String getSentiment() {
				return sentiment;
			}
			public void setSentiment(String sentiment) {
				this.sentiment = sentiment;
			}
			public String getAijiuTime() {
				return aijiuTime;
			}
			public void setAijiuTime(String aijiuTime) {
				this.aijiuTime = aijiuTime;
			}
			public String getStudyTimeStart() {
				return studyTimeStart;
			}
			public void setStudyTimeStart(String studyTimeStart) {
				this.studyTimeStart = studyTimeStart;
			}
			public String getStudyTimeEnd() {
				return studyTimeEnd;
			}
			public void setStudyTimeEnd(String studyTimeEnd) {
				this.studyTimeEnd = studyTimeEnd;
			}
			public String getSportsTimeStart() {
				return sportsTimeStart;
			}
			public void setSportsTimeStart(String sportsTimeStart) {
				this.sportsTimeStart = sportsTimeStart;
			}
			public String getSportsTimeEnd() {
				return sportsTimeEnd;
			}
			public void setSportsTimeEnd(String sportsTimeEnd) {
				this.sportsTimeEnd = sportsTimeEnd;
			}
			public String getAijiuTimeStart() {
				return aijiuTimeStart;
			}
			public void setAijiuTimeStart(String aijiuTimeStart) {
				this.aijiuTimeStart = aijiuTimeStart;
			}
			public String getAijiuTimeEnd() {
				return aijiuTimeEnd;
			}
			public void setAijiuTimeEnd(String aijiuTimeEnd) {
				this.aijiuTimeEnd = aijiuTimeEnd;
			}
			public int getLuSum() {
				return luSum;
			}
			public void setLuSum(int luSum) {
				this.luSum = luSum;
			}
		
			
			
			
			
	         
	         
	         
}
