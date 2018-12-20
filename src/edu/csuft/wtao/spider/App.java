package edu.csuft.wtao.spider;

//import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author yuyao
 *
 */
public class App {
	//alt+/
	public static void main(String[] args) {
		//�̳߳�
		//�̶���С
		ExecutorService pool= Executors.newFixedThreadPool(4);
		//���ޣ����棩
		pool=Executors.newCachedThreadPool();
//		//һ���߳�
//		pool=Executors.newSingleThreadExecutor();
		ArrayList<Film> list=new ArrayList<>();
		String url="https://movie.douban.com/top250?start";
		for (int i = 0; i <=10; i++) {
			String path =String.format("%s=%d",url,i*25);
			pool.submit(new Spider(path,list));
		}

        pool.shutdown();
        
        while(!pool.isTerminated()) {
        	try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        System.out.println(pool.isTerminated());
        //��������
        Collections.sort(list);
        
        System.out.println(list.size());
        
        ExecutorService pool2=Executors.newFixedThreadPool(4);
        for (Film film1 : list) {
			System.out.println(film1.url);
//			System.out.print(film1.toCSV());
			pool2.execute(new SpiderFilmDetail(film1.url,list));
		}

        //д���ļ�
//        String file="d:/code/film.csv"; //����·��
//        file="film.csv";  //���·��
//        //����
//        Collections.sort(list);
//        //io
//        try (FileWriter out=new FileWriter(file,true)) {
//			//д����
//        	for (Film film : list) {
//				out.write(film.toCSV());
//			}
//        	System.out.println("ok");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
}
}
