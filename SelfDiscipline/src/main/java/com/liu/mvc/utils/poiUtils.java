package com.liu.mvc.utils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.liu.mvc.pojo.excelPoi;

public class poiUtils {
				
				public static HSSFWorkbook getHSSFWrokbook(String sheetName,excelPoi ep) {
					HSSFWorkbook  wb=new HSSFWorkbook();
					
					HSSFSheet sheet= wb.createSheet(sheetName);
					
					HSSFRow row=sheet.createRow(0);
					
					 // 第四步，创建单元格，并设置值表头 设置表头居中
			        HSSFCellStyle style = wb.createCellStyle();
			        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			        
			        //声明列对象
			        HSSFCell cell = null;
			        List<String> title=ep.getTitle();
			        //创建标题
			        for(int i=0;i<title.size();i++){
			            cell = row.createCell(i);
			            cell.setCellValue(title.get(i));
			            cell.setCellStyle(style);
			        }

			        //创建内容
			        List<List<String>> data=ep.getData();
			     
			        for(int i=0;i<data.size();i++){
			            row = sheet.createRow(i + 1);
			            for(int j=0;j<data.get(i).size();j++){
			                //将内容按顺序赋给对应的列对象
			                row.createCell(j).setCellValue(data.get(i).get(j));
			            }
			        }
			        return wb;
				}
}
