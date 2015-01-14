package DemoDto;

import java.util.ArrayList;
/**
 * @author fengche
 *保存数据的类（get、set方法）
 */
public class MyDto {

	private ArrayList<String> arrayList = new ArrayList<String>();
	private String date;
	//获取时间对象
	public String getDate() {
		return date;
	}
	//设置时间对象
	public void setDate(String date) {
		this.date = date;
	}
	//获取arraylist对象
	public ArrayList<String> getArrayList() {
		return arrayList;
	}
	//设置arraylist对象
	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}
	
}
