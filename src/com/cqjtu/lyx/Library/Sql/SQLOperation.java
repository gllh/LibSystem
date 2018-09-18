package com.cqjtu.lyx.Library.Sql;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月16日 下午9:44:16
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cqjtu.lyx.Library.Date.Date;
import com.cqjtu.lyx.Library.Entity.AdminInfo;
import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Entity.ReaderInfo;

public class SQLOperation {
	static PreparedStatement ps = null;
	static Connection ct = null;
	static ResultSet rs = null;

	public SQLOperation() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;DatabaseName=Library",
//					"jdbc:sqlserver://10.1.161.138:1434;DatabaseName=Library",
					"sa", 
					"123456");
//					"1052024time.");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public int logCheck(String name, String password) {
		int i = 0;
		try {
			ArrayList<String> strArray = new ArrayList<String>();
			String sql = "select * from 管理员";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("登录名");
				strArray.add(s);
				count++;
				System.out.println(s);
				s = rs.getString("密码");
				strArray.add(s);
				count++;
			}
//			System.out.println(count);
//			strArray.add(Integer.toString(count));
			for(;count>=0;count--){
				System.out.println(strArray.get(count-1));
				if (strArray.get(count-2).equals(name)
						&& strArray.get(count-1).equals(password)) {
					i = 1;
					break;
				}
			}
			
//			if (strArray.get(0).equals(name)
//					&& strArray.get(1).equals(password)) {
//				i = 1;
//
//			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.print(i);
		return i;
	}

	public ArrayList addBookJudgement1() {
		ArrayList<String> strArray = new ArrayList<String>();
		ArrayList<String> strArray1 = new ArrayList<String>();
		try {
			String sql = "select 书名 from 图书信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("书名");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public ArrayList addReaderJudgement1() {
		ArrayList<String> strArray = new ArrayList<String>();
		ArrayList<String> strArray1 = new ArrayList<String>();
		try {
			String sql = "select 姓名 from 读者信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("姓名");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public ArrayList addBookJudgement() {
		ArrayList<String> strArray = new ArrayList<String>();
		ArrayList<String> strArray1 = new ArrayList<String>();
		try {
			String sql = "select 编号 from 图书信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("编号");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}
	public ArrayList addAdminJudgement() {
		ArrayList<String> strArray = new ArrayList<String>();
		ArrayList<String> strArray1 = new ArrayList<String>();
		try {
			String sql = "select 登录名 from 管理员";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("登录名");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}
	public ArrayList addReaderJudgement() {
		ArrayList<String> strArray = new ArrayList<String>();
		ArrayList<String> strArray1 = new ArrayList<String>();
		try {
			String sql = "select 编号 from 读者信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("编号");
				strArray.add(s);
				count++;
			}
			strArray.add(Integer.toString(count));
			for (; count >= 0; count--) {
				strArray1.add(strArray.get(count));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray1;
	}

	public void saveReader(ReaderInfo reader) {
		try {
			String sql = "insert into 读者信息(编号,姓名,性别,专业,年级) values (?,?,?,?,?);";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, reader.getNumber());
			pts.setString(2, reader.getName());
			pts.setString(3, reader.getSex());
			pts.setString(4, reader.getDpt());
			pts.setInt(5, reader.getGrade());

			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void saveBook(BookInfo book) {
		try {
			String sql = "insert into 图书信息(编号,书名,作者,出版社,出版日期,摘要,总量,现存量) values (?,?,?,?,?,?,?,?);";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, book.getNumber());
			pts.setString(2, book.getName());
			pts.setString(3, book.getAuthor());
			pts.setString(4, book.getPress());
			pts.setString(5, book.getPressTime());
			pts.setString(6, book.getBookAbstract());
			pts.setInt(7, book.getTotal());
			pts.setInt(8, book.getRemain());
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	public void saveAdmin(AdminInfo ai) {
		try {
			String sql = "insert into 管理员(管理员编号,登录名,密码) values (?,?,?);";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, ai.getAdminnumber());
			pts.setString(2, ai.getAdminname());
			pts.setString(3, ai.getAdminpass());
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	public String searchBookByName(BookInfo book) {
		String s = null;
		try {
			String sql = "select 编号 from 图书信息 where 书名=?;";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, book.getName());
			rs = ps.executeQuery();
			while (rs.next()) {
				s = rs.getString("编号");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return s;
	}

	public String searchReaderByName(ReaderInfo reader) {
		String s = null;
		try {
			String sql = "select 编号 from 读者信息 where 姓名=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, reader.getName());
			rs = pts.executeQuery();
			while (rs.next()) {
				s = rs.getString("编号");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}

	public int deleteBook(BookInfo book) {
		try {
			String sql = "delete from 图书信息 where 编号=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, book.getNumber());
			int count = pts.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public int deleteReader(ReaderInfo reader) {
		try {
			String sql = "delete from 读者信息 where 编号=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, reader.getNumber());
			int count = pts.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	public int deleteAdmin(AdminInfo admin) {
		try {
			String sql = "delete from 管理员 where 登录名=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, admin.getAdminname());
			int count = pts.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public ArrayList outputBook(BookInfo book) {
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select * from 图书信息 where 编号=?;";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, book.getNumber());
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("编号");
				strArray.add(s);
				s = rs.getString("书名");
				strArray.add(s);
				s = rs.getString("作者");
				strArray.add(s);
				s = rs.getString("出版社");
				strArray.add(s);
				s = rs.getString("出版日期");
				strArray.add(s);
				s = rs.getString("摘要");
				strArray.add(s);
				s = rs.getString("总量");
				strArray.add(s);
				s = rs.getString("现存量");
				strArray.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray;
	}

	public ArrayList outputReader(ReaderInfo reader) {
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select * from 读者信息 where 编号=?;";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, reader.getNumber());
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("编号");
				strArray.add(s);
				s = rs.getString("姓名");
				strArray.add(s);
				s = rs.getString("性别");
				strArray.add(s);
				s = rs.getString("专业");
				strArray.add(s);
				s = rs.getString("年级");
				strArray.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray;
	}
	public ArrayList outputAdmin(AdminInfo admin) {
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select * from 管理员 where 登录名=?;";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, admin.getAdminname());
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("管理员编号");
				strArray.add(s);
				s = rs.getString("登录名");
				strArray.add(s);
				s = rs.getString("密码");
				strArray.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return strArray;
	}
	public void inputBook(BookInfo book) {
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "update 图书信息 set 书名=?,作者=?,出版社=?,出版日期=?,摘要=?,总量=?,现存量=?  where 编号=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, book.getName());
			pts.setString(2, book.getAuthor());
			pts.setString(3, book.getPress());
			pts.setString(4, book.getPressTime());
			pts.setString(5, book.getBookAbstract());
			pts.setInt(6, book.getTotal());
			pts.setInt(7, book.getRemain());
			pts.setString(8, book.getNumber());
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inputReader(ReaderInfo reader) {
		try {
			String sql = "update 读者信息 set 姓名=?,性别=?,专业=?,年级=?  where 编号=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, reader.getName());
			pts.setString(2, reader.getSex());
			pts.setString(3, reader.getDpt());
			pts.setInt(4, reader.getGrade());
			pts.setString(5, reader.getNumber());
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void inputAdmin(AdminInfo admin) {
		try {
			System.out.println("DQAWDQWDQWD");
			String sql = "update 管理员 set 管理员编号=?,密码=?  where 登录名=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, admin.getAdminnumber());
			pts.setString(2, admin.getAdminpass());
			pts.setString(3, admin.getAdminname());
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Object[][] allBook(BookInfo book) {
		Object[][] ob = new Object[60][8];
		int n = 0;
		try {
			String sql = "select * from 图书信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("编号");
				ob[n][1] = rs.getString("书名");
				ob[n][2] = rs.getString("作者");
				ob[n][3] = rs.getString("出版社");
				ob[n][4] = rs.getString("出版日期");
				ob[n][5] = rs.getString("摘要");
				ob[n][6] = rs.getString("总量");
				ob[n][7] = rs.getString("现存量");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}
	public Object[][] allAdmin(AdminInfo admin) {
		Object[][] ob = new Object[60][3];
		int n = 0;
		try {
			String sql = "select * from 管理员";
			PreparedStatement ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("管理员编号");
				ob[n][1] = rs.getString("登录名");
				ob[n][2] = rs.getString("密码");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public Object[][] allReader(ReaderInfo reader) {
		Object[][] ob = new Object[60][5];
		int n = 0;
		try {
			String sql = "select * from 读者信息";
			PreparedStatement ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("编号");
				ob[n][1] = rs.getString("姓名");
				ob[n][2] = rs.getString("性别");
				ob[n][3] = rs.getString("专业");
				ob[n][4] = rs.getString("年级");
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public void insertBorrow(String bookNumber, String readerNumber,
			String borrowTime, String deadline) {
		try {
			String sql = "insert into 图书借阅 ( 图书编号 , 读者编号,借阅时间, 应还时间) values(?,?,?,?)";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, bookNumber);
			pts.setString(2, readerNumber);
			pts.setString(3, borrowTime);
			pts.setString(4, deadline);
			pts.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public int reBorrowCheck(String bookNumber, String readerNumber) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 图书借阅  where 图书编号=? and 读者编号=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, bookNumber);
			ps.setString(2, readerNumber);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("图书编号");
				strArray.add(s);
				s = rs.getString("读者编号");
				strArray.add(s);
				count++;
			}
			System.out.println(strArray);
			if (count >= 1) {
				i = 1;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int deadLineCheck(String readerNumber, long currentTime) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 图书借阅  where 读者编号=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, readerNumber);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("应还时间");
				strArray.add(s);
				count++;
			}
			if(count>0){
				if (Long.parseLong(strArray.get(count - 1)) <= currentTime) {
					i++;
				}
				count--;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int returnCheck(String bookNumber, String readerNumber) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 图书借阅  where 图书编号=? and 读者编号=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, bookNumber);
			ps.setString(2, readerNumber);
			rs = ps.executeQuery();
			while (rs.next()) {
				String s = rs.getString("图书编号");
				strArray.add(s);
				s = rs.getString("读者编号");
				strArray.add(s);
			}
			System.out.println(strArray);
			if (strArray.get(0) != bookNumber
					|| strArray.get(1) != readerNumber) {
				i = 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			i = 1;
		}

		System.out.print(i);
		return i;
	}

	public int deleteResult(String bookNumber, String readerNumber) {
		try {
			String sql = "delete from 图书借阅 where 图书编号=? and 读者编号=?;";
			PreparedStatement pts = ct.prepareStatement(sql);
			pts.setString(1, bookNumber);
			pts.setString(2, readerNumber);
			int count = pts.executeUpdate();
			if (count == 1) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public Object[][] borrowList() {
		Date dateCal = new Date();
		Object[][] ob = new Object[100][5];
		int n = 0;
		try {
			String sql = "select * from 图书借阅";
			PreparedStatement ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("图书编号");
				ob[n][1] = rs.getString("读者编号");
				String s = dateCal.borrowTimeInterface(Long.parseLong(rs
						.getString("借阅时间")));
				ob[n][2] = s;
				long re = Long.parseLong(rs.getString("应还时间"));
				s = dateCal.borrowTimeInterface(re);
				ob[n][3] = s;
				long re1 = System.currentTimeMillis();
				if (re1 > re) {
					ob[n][4] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
				} else {
					ob[n][4] = "否";
				}
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public Object[][] borrowListForReader(String readerNumber) {
		Date dateCal = new Date();
		Object[][] ob = new Object[100][4];
		int n = 0;
		try {
			String sql = "select * from 图书借阅 where 读者编号=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, readerNumber);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("图书编号");
				String s = dateCal.borrowTimeInterface(Long.parseLong(rs
						.getString("借阅时间")));
				ob[n][1] = s;
				long re = Long.parseLong(rs.getString("应还时间"));
				s = dateCal.borrowTimeInterface(re);
				ob[n][2] = s;
				long re1 = System.currentTimeMillis();
				if (re1 > re) {
					ob[n][3] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
				} else {
					ob[n][3] = "否";
				}
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public Object[][] borrowListForBook(String bookNumber) {
		Date dateCal = new Date();
		Object[][] ob = new Object[100][8];
		int n = 0;
		try {
			String sql = "select * from 图书借阅 where 图书编号=?";
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setString(1, bookNumber);
			rs = ps.executeQuery();
			while (rs.next()) {
				ob[n][0] = rs.getString("读者编号");
				String s = dateCal.borrowTimeInterface(Long.parseLong(rs
						.getString("借阅时间")));
				ob[n][1] = s;
				long re = Long.parseLong(rs.getString("应还时间"));
				s = dateCal.borrowTimeInterface(re);
				ob[n][2] = s;
				long re1 = System.currentTimeMillis();
				if (re1 > re) {
					ob[n][3] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
				} else {
					ob[n][3] = "否";
				}
				n++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ob;
	}

	public int deleteBookCheck(String bookNumber) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 图书借阅";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, bookNumber);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("图书编号");
				strArray.add(s);
				count++;
			}
			if(count>0){
				if (strArray.get(count - 1).equals(bookNumber)) {
					i++;
				}
				count--;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
	public int deleteAdminCheck(String adminNumber) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 管理员";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, bookNumber);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("管理员编号");
				strArray.add(s);
				count++;
			}
			if(count>0){
				if (strArray.get(count - 1).equals(adminNumber)) {
					i++;
				}
				count--;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public int deleteReaderCheck(String readerNumber) {
		int i = 0;
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			String sql = "select *  from 图书借阅";
			PreparedStatement ps = ct.prepareStatement(sql);
			// ps.setString(1, bookNumber);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				String s = rs.getString("读者编号");
				strArray.add(s);
				count++;
			}
			if(count>0){
				if (strArray.get(count - 1).equals(readerNumber)) {
					i++;
				}
				count--;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
}