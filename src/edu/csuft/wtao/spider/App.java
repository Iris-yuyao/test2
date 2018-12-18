package edu.csuft.wtao.spider;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author yuyao
 *
 */
public class App {
	//alt+/
	public static void main(String[] args) {
		//目标 URL
		String url="http://movie.douban.com/top250";
		//使用jsoup抓取文档
		try {
			Document doc=Jsoup.connect(url).get();
			/**
			 * 在网格视图中找item (加空格)
			 */
			Elements es= doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//创建一个存储影片列表
			ArrayList<Film> list=new ArrayList<>();
			
			for(Element e :es)
			{
				Film f=new Film();
				//每一部影片
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().attr("src");
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num=e.select(".star span").last().text();
				f.num=Integer.parseInt(num.substring(0,num.length()-3));
				f.quote=e.select(".inq").first().text();
				System.out.println(f);
//              f.id
//              f.title
				list.add(f);
			}
			//System.out.println(es.size());
			//String title=doc.title();
			//String data=doc.data();
			//System.out.println(title);
			//System.out.println(data);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
