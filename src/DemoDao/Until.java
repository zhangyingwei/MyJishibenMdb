package DemoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.omg.CORBA.PRIVATE_MEMBER;

import DemoDto.MyDto;

/**
 * @author fengche
 *操作数据库的类
 *包括查询、跟插入
 *传入一个Dto对象
 */
public class Until {
	private MyDto dto;

	public Until(MyDto dto) {
		this.dto = dto;
	}

	/**
	 * 数据库查询的方法
	 * 没有返回值
	 * */
	public void selectall() throws Exception {
		Dao until = new Dao();//声明一个until对象
		ArrayList<String> arrayList = new ArrayList<String>();//存放取出来的值
		String sql = "select * from notebook";//数据库操作语句
		Connection con = until.getcon();//获取数据库连接
		PreparedStatement pStatement = con.prepareStatement(sql);//获取连接
		ResultSet rSet = pStatement.executeQuery();//操作数据库语句
		while (rSet.next()) {
			arrayList.add(rSet.getString("myname"));//获取name字段
			arrayList.add(rSet.getString("content"));//获取content字段
			arrayList.add(rSet.getString("mytime"));//获取mytime字段
		}
		dto.setArrayList(arrayList);//dto传值
		rSet.close();//关闭resultset
		pStatement.close();//关闭preparestatement
		until.closecon();//关闭connection
	}
	/**
	 * 数据库插入的方法
	 * 没有返回值
	 * */
	public void insertOne(String myname, String content, String time)
			throws Exception {
		Dao until = new Dao();//声明一个until对象
		Connection con = until.getcon();//获取数据库连接
		String sql = "insert into notebook(myname,content,mytime) values(?,?,?)";//操作数据库语句
		PreparedStatement pStatement = con.prepareStatement(sql);//获取连接
		pStatement.setString(1, myname);
		pStatement.setString(2, content);
		pStatement.setString(3, time);
		pStatement.executeUpdate();//操作数据库语句
		pStatement.close();//关闭preparestatement
		until.closecon();//关闭connection
	}
	/**
	 * 查找数据的方法
	 * */
	public void findstring(String name) throws Exception {
		Dao until = new Dao();//声明一个until对象
		ArrayList<String> arrayList = new ArrayList<String>();//存放取出来的值
		String sql = "select * from notebook where myname=?";//数据库操作语句
		Connection con = until.getcon();//获取数据库连接
		PreparedStatement pStatement = con.prepareStatement(sql);//获取连接
		pStatement.setString(1, name);
		ResultSet rSet = pStatement.executeQuery();//操作数据库语句
		while (rSet.next()) {
			arrayList.add(rSet.getString("myname"));//获取name字段
			arrayList.add(rSet.getString("content"));//获取content字段
			arrayList.add(rSet.getString("mytime"));//获取mytime字段
		}
		dto.setArrayList(arrayList);//dto传值
		rSet.close();//关闭resultset
		pStatement.close();//关闭preparestatement
		until.closecon();//关闭connection
	}
	/**
	 *删除student表中的数据
	 */
	public void deletepeople(String name) throws Exception{
		Dao until = new Dao();//声明一个dao对象
		Connection con = until.getcon();//获取连接
		String sql = "delete from notebook where myname='"+name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//获取对象
		pStatement.execute();//执行sql语句
		pStatement.close();//关闭对象
		until.closecon();//关闭连接
		JOptionPane.showMessageDialog(null, "删除成功");//信息提示框
	}
}
