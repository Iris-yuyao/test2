package edu.csuft.wtao.spider;
/**
 * ����һ�����Խ����߳�ִ�е�����
 * @author ������
 *
 */
//runable �ӿ�
public class Task  implements Runnable{
 
	//���
	int n;
	
	
	public Task(int n) {
		super();
		this.n = n;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		System.out.println(name +"��ʼ :"+ n);
		//��ʱ
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name +"���� :"+ n);
	}
	

}