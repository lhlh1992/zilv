//package com.liu.mvc.utils;
//
//import java.awt.Color;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import com.liu.mvc.pojo.excelPoi;
//
///***
// * 功能：导入导出工具类
// * 创建人：liu_hui
// * 创建时间:2019.5.18
// * @author Administrator
// *
// */
////@Component
////@ConfigurationProperties(prefix = "down")
//public class ExcelUtil {
//	
////	 private  String downpath;
////
////	public String getDownpath() {
////		return downpath;
////	}
////
////	public void setDownpath(String downpath) {
////		this.downpath = downpath;
////	}
////	 
//	 
//	
//
//	/**
//     * 使用浏览器选择路径下载
//     * @param response
//     * @param fileName
//     * @param data
//     * @throws Exception
//     */
////    public static void exportExcel(HttpServletResponse response, String fileName, excelPoi data) throws Exception {
////        // 告诉浏览器用什么软件可以打开此文件
////        response.setHeader("content-Type", "application/vnd.ms-excel");
////        // 下载文件的默认名称
////        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xls", "utf-8"));
////        exportExcel(data, response.getOutputStream());
////    }
// 
//    public static int generateExcel(excelPoi excelData, String path) throws Exception {
//        File f = new File(path);
//        FileOutputStream out = new FileOutputStream(f);
//        return exportExcel(excelData, out);
//    }
// 
//    private static int exportExcel(excelPoi data, OutputStream out) throws Exception {
//        XSSFWorkbook wb = new XSSFWorkbook();
//        int rowIndex = 0;
//        try {
//            String sheetName = data.getTabName();
//            if (null == sheetName) {
//                sheetName = "Sheet1";
//            }
//            XSSFSheet sheet = wb.createSheet(sheetName);
//            rowIndex = writeExcel(wb, sheet, data);
//            wb.write(out);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //此处需要关闭 wb 变量
//            out.close();
//        }
//        return rowIndex;
//    }
// 
//    /**
//     * 表不显示字段
//     * @param wb
//     * @param sheet
//     * @param data
//     * @return
//     */
////    private static int writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data) {
////        int rowIndex = 0;
////        writeTitlesToExcel(wb, sheet, data.getTitles());
////        rowIndex = writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
////        autoSizeColumns(sheet, data.getTitles().size() + 1);
////        return rowIndex;
////    }
// 
//    /**
//     * 表显示字段
//     * @param wb
//     * @param sheet
//     * @param data
//     * @return
//     */
//    private static int writeExcel(XSSFWorkbook wb, XSSFSheet sheet, excelPoi data) {
//        int rowIndex = 0;
//        
//        rowIndex = writeTitlesToExcel(wb, sheet, data.getTitle());
//        rowIndex = writeRowsToExcel(wb, sheet, data.getData(), rowIndex);
//       // autoSizeColumns(sheet, data.getTitle().size() + 1);
//        return rowIndex;
//    }
//    /**
//     * 设置表头
//     *
//     * @param wb
//     * @param sheet
//     * @param titles
//     * @return
//     */
//    private static int writeTitlesToExcel(XSSFWorkbook wb, XSSFSheet sheet, List<String> titles) {
//        int rowIndex = 0;
//        int colIndex = 0;
//        Font titleFont = wb.createFont();
//        //设置字体
//        titleFont.setFontName("微软雅黑");
//        //设置粗体
//      //  titleFont.setBoldweight(Short.MAX_VALUE);
//        //设置字号
//        titleFont.setFontHeightInPoints((short) 14);
//        //设置颜色
//        titleFont.setColor(IndexedColors.BLACK.index);
//        XSSFCellStyle titleStyle = wb.createCellStyle();
//        //水平居中
//      //  titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
//        //垂直居中
//      //  titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
//        //设置图案颜色
//        titleStyle.setFillForegroundColor(new XSSFColor(new Color(182, 184, 192)));
//        //设置图案样式
//     //   titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
//        titleStyle.setFont(titleFont);
//        setBorder(titleStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));
//        //sheet.setColumnWidth(0, 255);
//        Row titleRow = sheet.createRow(rowIndex);
//        
//        titleRow.setHeightInPoints(25);
//        colIndex = 0;
//        for (String field : titles) {
//            Cell cell = titleRow.createCell(colIndex);
//            cell.setCellValue(field);
//            cell.setCellStyle(titleStyle);
//            
//            colIndex++;
//        }
//        rowIndex++;
//        return rowIndex;
//    }
// 
//    /**
//     * 设置内容
//     *
//     * @param wb
//     * @param sheet
//     * @param rows
//     * @param rowIndex
//     * @return
//     */
//    private static int writeRowsToExcel(XSSFWorkbook wb, XSSFSheet sheet, List<List<String>> rows, int rowIndex) {
//        int colIndex;
//        Font dataFont = wb.createFont();
//        dataFont.setFontName("simsun");
//        dataFont.setFontHeightInPoints((short) 14);
//        dataFont.setColor(IndexedColors.BLACK.index);
// 
//        XSSFCellStyle dataStyle = wb.createCellStyle();
//        String cnt = "cnt" + "\r\n";
//        //内容强制换行
//        //dataStyle .setWrapText(true);
//        dataStyle.setFont(dataFont);
//        setBorder(dataStyle, BorderStyle.THIN, new XSSFColor(new Color(0, 0, 0)));
//        for (List<String> rowData : rows) {
//            Row dataRow = sheet.createRow(rowIndex);
//            dataRow.setHeightInPoints(25);
//            colIndex = 0;
//            for (Object cellData : rowData) {
//                Cell cell = dataRow.createCell(colIndex);
//                if (cellData != null) {
//                    cell.setCellValue(cellData.toString());
//                } else {
//                    cell.setCellValue("");
//                }
//                cell.setCellStyle(dataStyle);
//                colIndex++;
//            }
//            rowIndex++;
//        }
//        return rowIndex;
//    }
// 
//    /**
//     * 自动调整列宽
//     *
//     * @param sheet
//     * @param columnNumber
//     */
//    private static void autoSizeColumns(XSSFSheet sheet, int columnNumber) {
//        for (int i = 0; i < columnNumber; i++) {
//            int orgWidth = sheet.getColumnWidth(i);
//            sheet.autoSizeColumn(i, true);
//            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
//            if (newWidth > orgWidth) {
//                sheet.setColumnWidth(i, newWidth);
//            	
//            	
//            } else {
//                sheet.setColumnWidth(i, orgWidth);
//            }
//        }
//    }
// 
//    /**
//     * 设置边框
//     *
//     * @param style
//     * @param border
//     * @param color
//     */
//    private static void setBorder(XSSFCellStyle style, BorderStyle border, XSSFColor color) {
//        style.setBorderTop(border);
//        style.setBorderLeft(border);
//        style.setBorderRight(border);
//        style.setBorderBottom(border);
//        style.setBorderColor(BorderSide.TOP, color);
//        style.setBorderColor(BorderSide.LEFT, color);
//        style.setBorderColor(BorderSide.RIGHT, color);
//        style.setBorderColor(BorderSide.BOTTOM, color);
//    }
//    
//    
//}
