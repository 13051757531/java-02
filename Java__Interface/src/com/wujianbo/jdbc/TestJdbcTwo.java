package com.wujianbo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestJdbcTwo {

	// 数据库驱动程序类
	private String driverClassName = "com.mysl.jdbc.Driver";
	// 数据库连接字符串
	static private String url = "jdbc:mysql://localhost:3306/learn?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestJdbcTwo tj= new TestJdbcTwo();
		//tj.seachData();
		//tj.insertData();
		//tj.updateDate();
		//tj.deleteData();
		//tj.seachDataTwo();
		tj.psInsert();

	}
 
	//数据库查询
	private void seachData() throws Exception {
		//new com.mysql.jdbc.Driver();
		//数据库连接
		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement();

		System.out.println(conn);
		System.out.println(stmt);//游标

		// 查询数据库
		String sql = "select count(*) from user";

		ResultSet rs = stmt.executeQuery(sql);
		
		rs.next();//让结果集定位到第一行
		System.out.println(rs.getInt(1));//获取第一列结果
		
		//关闭数据库
		conn.close();
		System.out.println(rs);
		
		

	}
	
	//数据库查询
		private void seachDataTwo() throws Exception {
			//new com.mysql.jdbc.Driver();
			//数据库连接
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();

			System.out.println(conn);
			System.out.println(stmt);//游标

			// 查询数据库
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){//让结果集定位到第一行
				System.out.print(rs.getInt(1)+"\t");//获取第一列结果
				System.out.print(rs.getString("username")+"\t");//获取第一列结果
				System.out.print(rs.getString("phone")+"\t");//获取第一列结果
				System.out.println();
			};
			
			
			//关闭数据库
			conn.close();
			System.out.println(rs);
			
			

		}

	//数据库插入
	private void insertData() throws Exception {
		// TODO Auto-generated method stub
		//建立同数据库的连接，获取游标
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		
		//插入数据
		String sql= "insert into user values(0, 'wujianbo',  'wujianbo', '13051757531', '1154632528@qq.com')";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//关闭数据库
		cnn.close();
		System.out.println("数据库插入成功");
        
	}
	
	private void psInsert() throws Exception {
		// TODO Auto-generated method stub
		//连接数据库
		Connection cnn= DriverManager.getConnection(url);
		//new com.mysql.jdbc.Driver();
		String sql= "insert into user(username, password, phone, email) values(?, ?, ?, ?)";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setString(1, "hujiandong");
		ps.setString(2, "hujiandong");
		ps.setString(3, "13051757531");
		ps.setString(4, "1154632528@qq.com");
		
		//插入数据
		ps.executeUpdate();
		//断开同数据库的连接
		cnn.close();

	}

	//数据库更新
	private void updateDate() throws Exception {
		// TODO Auto-generated method stub
		//建立同数据库的连接
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		//更新操作
		String sql= "update user set username='wudongmei' where id='1'";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//关闭数据库
		cnn.close();
		System.out.println("更新数据库成功！！");

	}

	//数据库中表的删除
	private void deleteData() throws Exception {
		// TODO Auto-generated method stub
		//同数据库连接
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		//进行删除
		String sql= "delete from user where id='2'";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//关闭数据库
		cnn.close();

	}

}
