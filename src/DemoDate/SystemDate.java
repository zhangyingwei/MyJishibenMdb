package DemoDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fengche
 *��ȡϵͳʱ�����
 *��һ��String���͵ķ���ֵ
 */
public class SystemDate {
	/**
	 *��ȡϵͳʱ��ķ���
	 */
	public String getdate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");//ָ��ϵͳʱ��ķ�������
		return sdf.format(date);
	}
}
