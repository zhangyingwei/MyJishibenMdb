package DemoDto;

import java.util.ArrayList;
/**
 * @author fengche
 *�������ݵ��ࣨget��set������
 */
public class MyDto {

	private ArrayList<String> arrayList = new ArrayList<String>();
	private String date;
	//��ȡʱ�����
	public String getDate() {
		return date;
	}
	//����ʱ�����
	public void setDate(String date) {
		this.date = date;
	}
	//��ȡarraylist����
	public ArrayList<String> getArrayList() {
		return arrayList;
	}
	//����arraylist����
	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}
	
}
