package test;

import java.io.IOException;
import java.nio.CharBuffer;

public class  ThreadTest implements Runnable{
  int i=5;
	@Override
	 public void run() {		

			this.SellTicket();
		//this.aa();
					 
	}

	/**
	 * 多线程，多个窗口售票案例
	 */
	public void SellTicket() {
		 int  count=100;//100张票
			while (count>0) {
					synchronized (this) {
						  if(count>0) {
						
								 System.out.println(Thread.currentThread().getName()+"开始售票.....");		
								 count --;
								 System.out.println(Thread.currentThread().getName()+"卖了1张票，还剩下"+count+"张票");
								 System.out.println("============================================");		
						 }		
					}		
			}
	}
	
	/**
	 * 测试synchronized同步
	 */
	public void aa() {
	synchronized (this) {
		i--;
		 System.out.println(Thread.currentThread().getName()+"==="+i);
	}
		
	}
	
	
	public void saipao() {
		double sum=20;
		
		double tu=0.5;
		
		double gui=0.1;
		
		System.out.println("开始跑。。。。。");
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		ThreadTest tr= new  ThreadTest();
		
	     for(int i=1;i<5;i++) {
	    	  Thread t=new Thread(tr,"窗口"+i);
	
	    	  t.start();
	    	  try {
				t.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 //  t.stop();
	    	  // t.suspend();
	     }
	
	}

  
		


}
