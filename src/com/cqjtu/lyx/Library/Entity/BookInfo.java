package com.cqjtu.lyx.Library.Entity;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��17�� ����1:33:24
 * @ClassName ������ û��
 * @Description ������ û��
 */
public class BookInfo {
	private String number;
	private String name;
	private String author;
	private String press;
	private String pressTime;
	private String bookAbstract;
	
	private int total;
	private int remain;

	// default constructor
	public BookInfo() {
	}

	public BookInfo(String number) {
		this.number = number;
	}

	public BookInfo(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public BookInfo(String number, String name, String author, String press,
			String pressTime, String bookAbstract, int total, int remain) {
		this.number = number;
		this.name = name;
		this.author = author;
		this.press = press;
		this.pressTime = pressTime;
		this.bookAbstract = bookAbstract;
		this.total = total;
		this.remain = remain;
	}
	public void setRemain(int i) {
		this.remain=i;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPress() {
		return press;
	}

	public String getPressTime() {
		return pressTime;
	}

	public String getBookAbstract() {
		return bookAbstract;
	}

	public int getTotal() {
		return total;
	}

	public int getRemain() {
		return remain;
	}
}
