package com.cqjtu.lyx.Library.Date;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月16日 下午1:46:08
 * @ClassName 类名称 没得
 * @Description 类描述 没得
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
