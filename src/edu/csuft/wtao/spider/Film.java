package edu.csuft.wtao.spider;
/**
 * ӰƬ
 * @author ������
 *
 */

public class Film implements Comparable<Film> {
	/**
	 * ӰƬ����
	 */
	String title;
	/**
	 * �����Ϣ
	 */
	String info;
	/**
	 * ��������
	 */
	double rating;
	/**
	 * ��������
	 */
	int num;
	/**
	 * ����
	 */
	int id;
	/**
	 * ����
	 */
	String poster;
	/**
	 * ����
	 */
	String quote;
	/**
	 * ӰƬ��ϸ·��
	 */
	String url;
	String toCSV() {
		return String.format("%d,%s,%d,%.1f\n",
				id,
				title,
				num,
				rating);
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", url=" + url + "]";
	}

	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return id-o.id;
	}
	

}
