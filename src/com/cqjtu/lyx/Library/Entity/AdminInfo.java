package com.cqjtu.lyx.Library.Entity;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��12�� ����10:52:24
 * @ClassName ������ û��
 * @Description ������ û��
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
