package com.wujianbo.woniuatm.databasetwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.wujianbo.woniuatm.database.CommonHandler;





public class CommonHandler {
	public static void main(String[] args) throws Exception {
		CommonHandler ch= new CommonHandler();
		//ch.insertData();
		//ch.checkLoginUser();
		//ch.checkUserName();
		//ch.displaybalance();
		//ch.updateBalance();
	}
	// 数据库连接字符串
	static private String url = "jdbc:mysql://localhost:3306/learn?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
	
	
	//注册时将用户信息写入数据库函数
	public void insertData(String[] str) throws Exception {
		String username= str[0];
		String password= str[1];
		Float balance= Float.parseFloat(str[2]);
		//String username= "aaa";
		//String password= "aaa";
		//String phone= "aaa";
		//String email= "aaa";
		//Float balance= 444F;
		// TODO Auto-generated method stub
		//连接数据库
		Connection cnn= DriverManager.getConnection(url);
		//Statement stmt= cnn.createStatement();
		//插入数据
		String sql= "insert into user(username, password, balance) values(?, ?, ?)";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		//System.out.println(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setFloat(3 , balance); 
		ps.execute();
		//stmt.executeQuery(sql);
		//断开连接
		cnn.close();
		System.out.println("用户注册数据写入成功！！");

	}
	//登录时验证用户是否存在(账号、密码)
	public Boolean checkLoginUser(String[] str) throws Exception {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		String username= str[0];
		String password= str[1];
		//连接数据库
		String sql= "select count(*) from user where username=? and password= ?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//获取数据
		pr.setString(1, username);
		pr.setString(2, password);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//进行用户、密码的判断
		//System.out.println(rs.getInt(1));
		if(rs.getInt(1) >= 1) {
			isOk= true;
		}else {
			isOk= false;
		}
		//System.out.println(isOk);
		
		//关闭数据库
		cnn.close();
		
		return isOk;

	}
	//注册时验证用户是否存在（注册、转账）
	public Boolean checkUserName(String str) throws Exception {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		//String username= str[0];
		//String password= str[1];
		String username= str;
		//连接数据库
		String sql= "select count(*) from user where username=?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//获取数据
		pr.setString(1, username);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//进行用户、密码的判断
		//System.out.println(rs.getInt(1));
		if(rs.getInt(1) >= 1) {
			isOk= true;
		}else {
			isOk= false;
		}
		//System.out.println(isOk);
		
		//关闭数据库
		cnn.close();
		
		return isOk;

	}
	//查询操作，获取用户余额
	public String displayBalance(String usernameOne) throws Exception {
		// TODO Auto-generated method stub
		String username= usernameOne;
		//String username= "wujianbo";
		//连接数据库
		Connection cnn= DriverManager.getConnection(url);
		String sql= "select balance from user where username=? ";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setString(1, username);
		
		//获取数据
		ResultSet rs= ps.executeQuery();
		 rs.next();
		String searchResult= rs.getString(1);
		//System.out.println("用户当前余额是："+);
		//关闭数据库
		cnn.close();
		return searchResult;

	}
	//取钱时，验证余额是否够（取钱，转账）
	//取钱时，将用户的账户余额更新（取钱、存钱、转账）
	public void updateBalance(String usernameOne, String balanceOne) throws Exception {
		// TODO Auto-generated method stub
		
		//String username= "wujianbo";
		//String balance= "444443";
		String username= usernameOne;
		String balance= balanceOne;
		Float balanceTwo= Float.parseFloat(balance);
		//连接数据库
		Connection cnn= DriverManager.getConnection(url);
		String sql= "update user set balance= ? where username= ?";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setFloat(1, balanceTwo);
		ps.setString(2, username);
		
		//获取数据
		ps.execute();
		
		//关闭数据库
		cnn.close();

	}
	

}
