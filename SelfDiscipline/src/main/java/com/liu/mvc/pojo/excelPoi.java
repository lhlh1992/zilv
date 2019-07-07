package com.liu.mvc.pojo;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//@Component
@ConfigurationProperties(prefix = "down")
public class excelPoi {
				
				private List<String> title;
				
				
				private List<List<String>> data;
				
				private String tabName;
				
				
				private  String downpath;
				 
				 
				
				
				

				public String getDownpath() {
					return downpath;
				}

				public void setDownpath(String downpath) {
					this.downpath = downpath;
				}

				public List<String> getTitle() {
					return title;
				}

				public void setTitle(List<String> title) {
					this.title = title;
				}

				

				
				public List<List<String>> getData() {
					return data;
				}

				public void setData(List<List<String>> data) {
					this.data = data;
				}

				public String getTabName() {
					return tabName;
				}

				public void setTabName(String tabName) {
					this.tabName = tabName;
				}
				
				
				
}
