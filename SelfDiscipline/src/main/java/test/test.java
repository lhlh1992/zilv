package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.poi.hssf.record.formula.functions.T;
import org.assertj.core.internal.bytebuddy.asm.Advice.This;

public class test {
	
	public test() {
		  System.out.println("111");
	}
	public test(int i) {
		 this();
	}
       
     		public static int aa(int c) {
     			  int a=2;
     			  int b=1;    			  
     			  int sum = 2*(c+1)- b*c;    
     			  
     			  System.out.println("滑下去"+c+"次,井"+sum+"米");
     			  return sum;  			  	
     		}
   
     //数组的差集，交集，并集 
     public static void array() {
    	 ArrayList<Integer> a=new ArrayList<>();
	  		a.add(1);
	  		a.add(3);
	  		a.add(2);
	  	 ArrayList<Integer> b=new ArrayList<>();
	  		b.add(3);
	  		b.add(4);
	  		b.add(5);
	  		
	  		 ArrayList<String> c=new ArrayList<>();	
	  		c.add("sdfsdf");
	  		c.add("===56sdf");
	  		c.add("水电费水电费");
	  		//list排序
	  		Collections.sort(c);
	  		System.out.println(c);
	  		
	  		  		
//	  		System.out.println("===============差集,a存在，b不存在");  		
//	  		a.removeAll(b);
//	    	System.out.println(a);
//	    	System.out.println("===============交集，a存在，b也存在");
//	    	a.retainAll(b);
//	    	System.out.println(a);
//	  		System.out.println("===============并集，a存在或者b也存在,2个数组去重");	  		
//	  		Set<Integer> s = new HashSet<>();
//	  		s.add(1);
//	  		s.add(2);
//	  		s.add(3);
//	  		s.add(3);
//	  		s.add(4);
//	  		s.add(5); 
//	  		System.out.println(s);
//	  		
     }		
     //字符串试验方法		
     public static void str() {
    	  String str="rwerewrwerwe";
    	  //字符串快速分割成一个个的字符
//    	  char[] ar=str.toCharArray();
//    	  for(int i =0;i<ar.length;i++) {
//    		   System.out.println(ar[i]);
//    	  }
    	  //字符串转为字节数组    	  
//    	  byte [] by=str.getBytes();
//    	  for(int i=0;i<by.length;i++) {
//    		   System.out.println(by[i]);
//    	  }
    	 //分割字符串为数组，部分字符需要\\转义 
    	  String ip="192.168.1.105";
    	  
    	  String [] ips=ip.split("\\.");	   
    	  for(int i=0;i<ips.length;i++) {
    		  System.out.println(ips[i]);
    	  }
    	  //根据多个字符串分隔，用以下形式| |    	  
    	  String two="sda#sadas-sadsad";
    	  String [] twos=two.split(" |#|-");
    	  System.out.println(twos.length);
    	  for(int i=0;i<twos.length;i++) {
    		   //System.out.println(twos[i]);
    	  }
     }
     
     //多参数试验
     public static void canshu(String ...str) {
    	     for(int i=0;i<str.length;i++) {
    	    	  System.out.println(str[i]);
    	     }
     }
     
     public static  void speak(int age) {
    	
    	 	System.out.println(age);
    	 	age=24;
     }
     
     //递归
     public static int  digui(int n) {
    	
    	  if(n==1) {
    		   return 1;
    	  }
    	 int a=digui(n-1);
    	 int  s=n*a;
    	  return  s;
     }
      
     //分别获取时间  年，月，日，时，分，秒   
     public static void calenderTest() {
    	  Calendar c = Calendar.getInstance();
    	  System.out.println(c.get(c.DAY_OF_WEEK)-1);
     }
    
     public static <T> void f(T t) {
    	  System.out.println(t);
     }
     
     
     
     //==================File操作文件，读取文件练习=====================
     	public static   void createFile() {
     				File fr=new File("C://Users//Administrator//Desktop//近期学习工作计划.txt");
     				byte [] br=new byte[1024];
     				try {
     					//文件输入流对象
						InputStream is=new FileInputStream(fr);
						//获取文件内容字节长度
						int length=is.available();
						//设置读取byte字节的长度，br为读取内容对象
						br=new byte[length];
						//读取操作
						int len = is.read(br);
						//关闭输入流
						is.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
     				//========================================================
     				File fw=new File("G://读和写Io.txt");
     				//判断文件或文件夹存在不存在
     				if(fw.exists()) {
     						try {
     							//创建个文件
								fw.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
     				}else {	
     							//删除文件
     							fw.delete();
     							try {
									fw.createNewFile();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
     				}
     				
     				try {
     					//文件输出流对象
						OutputStream os = new FileOutputStream(fw);
						//将刚才输入流读取文件的内容，通过文件输出流写入到创建的文件里
						os.write(br);
						os.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
     				
     				if(fw.exists()) {
     							System.out.println("创建成功");
     				}		
     	}
      
     //io流追加操作
     public static void wfile() {
    	 FileWriter fw = null;
    	 
    	
    	 try {
    		File f=new File("G://读和写Io.txt");
			fw = new FileWriter(f,true);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 PrintWriter pw = new PrintWriter(fw);
    	 
    	 pw.println("22222");
    	 pw.flush();
    	 
    	 try {
			 fw.flush();
			 pw.close();
	    	 fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 
    	 
    	 
     }
     	
     	
      public static void main(String[] args) {
    	  			
    	 
    	  
    	  System.out.println(UUID.randomUUID().toString());
    	   
    	
    	    		
	}

      

	
}
