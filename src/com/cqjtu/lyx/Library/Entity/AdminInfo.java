package com.cqjtu.lyx.Library.Entity;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月12日 下午10:52:24
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class AdminInfo {
	private String adminnumber;
	private String adminname;
	private String adminpass;

	// default constructor
	public AdminInfo() {
	}

	public AdminInfo(String adminname) {
		this.adminname = adminname;
	}
	public AdminInfo(String adminnumber,String adminname, String adminpass) {
		this.adminnumber=adminnumber;
		this.adminname = adminname;
		this.adminpass = adminpass;
	}

	public String getAdminnumber() {
		return adminnumber;
	}

	public void setAdminnumber(String adminnumber) {
		this.adminnumber = adminnumber;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpass() {
		return adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	
}
