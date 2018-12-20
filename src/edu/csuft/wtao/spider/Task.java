package edu.csuft.wtao.spider;
/**
 * 定义一个可以交给线程执行的任务
 * @author 刘玉瑶
 *
 */
//runable 接口
public class Task  implements Runnable{
 
	//编号
	int n;
	
	
	public Task(int n) {
		super();
		this.n = n;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		System.out.println(name +"开始 :"+ n);
		//延时
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name +"结束 :"+ n);
	}
	

}
