package guestbook;

import java.sql.Date;

public class Article {
	private int num;
	private String writer;
	private String pwd;
	private Date w_date;
	private String content;
	
	public Article() {}

	public Article(int num, String writer, String pwd, Date w_date, String content) {		
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.w_date = w_date;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", writer=" + writer + ", pwd=" + pwd + ", w_date=" + w_date + ", content="
				+ content + "]";
	}
	
	
	
	
	
	
}
