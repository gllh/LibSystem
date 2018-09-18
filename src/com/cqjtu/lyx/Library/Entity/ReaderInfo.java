package com.cqjtu.lyx.Library.Entity;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月15日 下午10:42:56
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class ReaderInfo {
	private String number, name, sex, dpt;
	private int grade;

	// default constructor
	public ReaderInfo() {
	}

	public ReaderInfo(String number) {
		this.number = number;
	}

	public ReaderInfo(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public ReaderInfo(String number, String name, String sex, String dpt,
			int grade) {
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.dpt = dpt;
		this.grade = grade;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getDpt() {
		return dpt;
	}

	public int getGrade() {
		return grade;
	}

}

