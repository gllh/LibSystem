package com.cqjtu.lyx.Library.Date;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��16�� ����1:46:08
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Date {
	public Date(){
		
	}
	public static String borrowTimeInterface(long time) {
		SimpleDateFormat df = (SimpleDateFormat) DateFormat.getInstance();
		df.applyPattern("yyyy-MM-dd");
		String s = df.format(time);
		return s;
	}
}
