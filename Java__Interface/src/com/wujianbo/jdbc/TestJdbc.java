package com.wujianbo.jdbc;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class TestJdbc {
	//���ݿ�����������
	private String driverClassName= "com.mysl.jdbc.Driver";
	//���ݿ������ַ���
	static private String url= "jdbc:mysql://localhost:3306/learn?"
						+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJdbc tj= new TestJdbc();
		//����ͬ���ݿ������
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs= null;
		try {
			new com.mysql.jdbc.Driver();
			conn= DriverManager.getConnection(url);
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conn);
		
		//��ѯ���ݿ�
		String sql= "select count(*) from user";
		
		try {
			rs= stmt.executeQuery(sql);
			rs.next();
			System.out.println(rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
	}
	
	public void getCountC() {
		// TODO Auto-generated method stub
		//Statement stmt= this.g

	}

}
