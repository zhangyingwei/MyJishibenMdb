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
 *�������ݿ����
 *������ѯ��������
 *����һ��Dto����
 */
public class Until {
	private MyDto dto;

	public Until(MyDto dto) {
		this.dto = dto;
	}

	/**
	 * ���ݿ��ѯ�ķ���
	 * û�з���ֵ
	 * */
	public void selectall() throws Exception {
		Dao until = new Dao();//����һ��until����
		ArrayList<String> arrayList = new ArrayList<String>();//���ȡ������ֵ
		String sql = "select * from notebook";//���ݿ�������
		Connection con = until.getcon();//��ȡ���ݿ�����
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		ResultSet rSet = pStatement.executeQuery();//�������ݿ����
		while (rSet.next()) {
			arrayList.add(rSet.getString("myname"));//��ȡname�ֶ�
			arrayList.add(rSet.getString("content"));//��ȡcontent�ֶ�
			arrayList.add(rSet.getString("mytime"));//��ȡmytime�ֶ�
		}
		dto.setArrayList(arrayList);//dto��ֵ
		rSet.close();//�ر�resultset
		pStatement.close();//�ر�preparestatement
		until.closecon();//�ر�connection
	}
	/**
	 * ���ݿ����ķ���
	 * û�з���ֵ
	 * */
	public void insertOne(String myname, String content, String time)
			throws Exception {
		Dao until = new Dao();//����һ��until����
		Connection con = until.getcon();//��ȡ���ݿ�����
		String sql = "insert into notebook(myname,content,mytime) values(?,?,?)";//�������ݿ����
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.setString(1, myname);
		pStatement.setString(2, content);
		pStatement.setString(3, time);
		pStatement.executeUpdate();//�������ݿ����
		pStatement.close();//�ر�preparestatement
		until.closecon();//�ر�connection
	}
	/**
	 * �������ݵķ���
	 * */
	public void findstring(String name) throws Exception {
		Dao until = new Dao();//����һ��until����
		ArrayList<String> arrayList = new ArrayList<String>();//���ȡ������ֵ
		String sql = "select * from notebook where myname=?";//���ݿ�������
		Connection con = until.getcon();//��ȡ���ݿ�����
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.setString(1, name);
		ResultSet rSet = pStatement.executeQuery();//�������ݿ����
		while (rSet.next()) {
			arrayList.add(rSet.getString("myname"));//��ȡname�ֶ�
			arrayList.add(rSet.getString("content"));//��ȡcontent�ֶ�
			arrayList.add(rSet.getString("mytime"));//��ȡmytime�ֶ�
		}
		dto.setArrayList(arrayList);//dto��ֵ
		rSet.close();//�ر�resultset
		pStatement.close();//�ر�preparestatement
		until.closecon();//�ر�connection
	}
	/**
	 *ɾ��student���е�����
	 */
	public void deletepeople(String name) throws Exception{
		Dao until = new Dao();//����һ��dao����
		Connection con = until.getcon();//��ȡ����
		String sql = "delete from notebook where myname='"+name+"'";
		PreparedStatement pStatement = con.prepareStatement(sql);//��ȡ����
		pStatement.execute();//ִ��sql���
		pStatement.close();//�رն���
		until.closecon();//�ر�����
		JOptionPane.showMessageDialog(null, "ɾ���ɹ�");//��Ϣ��ʾ��
	}
}
