package DemoDao;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	Connection con = null;

	/**
	 * ��ȡ���ݿ�����
	 * */
	public Connection getcon() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		this.con = DriverManager.getConnection("jdbc:odbc:note", "", "");//��ȡ���ݿ�����
		return con;
	}

	/**
	 * �ر����ݿ�����
	 * */
	public void closecon() throws Exception {
		this.con.close();
	}
}
