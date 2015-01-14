package DemoDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fengche
 *获取系统时间的类
 *有一个String类型的返回值
 */
public class SystemDate {
	/**
	 *获取系统时间的方法
	 */
	public String getdate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");//指定系统时间的返回类型
		return sdf.format(date);
	}
}
