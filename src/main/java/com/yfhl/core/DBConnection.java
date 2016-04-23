package com.yfhl.core;
/**
 * @author Chris li E-mail:lj520212@gmail.com
 * @version 创建时间：2015年12月10日 上午10:00:31
 * 类说明
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection conn = null;

	public static void init() {

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";//数据库的路径
		String url = "jdbc:mysql://192.168.31.200:3306/creatia";
		try {
			conn = DriverManager.getConnection(url, "root", "admini");//建立连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//此方法用于建立连接
	public static Connection getConnection() {

		if (conn == null)
			init();

		return conn;

	}
//关闭连接
	
	public static void close(Statement stmt,PreparedStatement pstmt,ResultSet rs){
		try {
			if (rs!=null)
				rs.close();
			if (stmt!=null)
				stmt.close();
			if (pstmt !=null)
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
