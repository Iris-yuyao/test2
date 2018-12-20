package edu.csuft.wtao.spider;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderFilmDetail implements Runnable {
/**
 * Ó°Æ¬µÄurl
 */
	String url;
/**
 * 
 */
	ArrayList<Film> list;
	
	public SpiderFilmDetail(String url, ArrayList<Film> list2) {
	super();
	this.url = url;
	this.list = list2;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc=Jsoup.connect(url).get();
			Element e=doc.getElementById("content");
			String name=e.selectFirst("h1 span").text();
			String year=e.selectFirst(".year").text();
			String director= e.select("#info span").get(0).selectFirst(".attrs a").text();
			String script= e.select("#info .attrs").get(1).text();
			String actor=e.select("#info .actor").get(0).text();
			System.out.println(name);
			System.out.println(year);
			System.out.println(director);
			System.out.println(script);
			System.out.println(actor);
			System.out.printf("%s,%s,%s,%s\n",
					year,
					name,
					director,
					script,
					actor
					
					
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
