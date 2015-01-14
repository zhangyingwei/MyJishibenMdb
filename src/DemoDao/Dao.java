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
	 * 获取数据库连接
	 * */
	public Connection getcon() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		this.con = DriverManager.getConnection("jdbc:odbc:note", "", "");//获取数据库连接
		return con;
	}

	/**
	 * 关闭数据库连接
	 * */
	public void closecon() throws Exception {
		this.con.close();
	}
}
