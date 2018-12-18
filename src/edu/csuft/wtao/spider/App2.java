package edu.csuft.wtao.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App2 {
	public static void main(String[] args) {
		/**
		 * Â·¾¶
		 */
		String url="https://movie.douban.com/subject/1291560/";
		try {
			Document doc2=Jsoup.connect(url).get();
			Element el= doc2.selectFirst("#content");
			System.out.println(el);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
