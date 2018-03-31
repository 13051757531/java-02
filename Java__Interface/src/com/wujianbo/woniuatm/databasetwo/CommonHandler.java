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
	// ���ݿ������ַ���
	static private String url = "jdbc:mysql://localhost:3306/learn?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
	
	
	//ע��ʱ���û���Ϣд�����ݿ⺯��
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
		//�������ݿ�
		Connection cnn= DriverManager.getConnection(url);
		//Statement stmt= cnn.createStatement();
		//��������
		String sql= "insert into user(username, password, balance) values(?, ?, ?)";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		//System.out.println(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setFloat(3 , balance); 
		ps.execute();
		//stmt.executeQuery(sql);
		//�Ͽ�����
		cnn.close();
		System.out.println("�û�ע������д��ɹ�����");

	}
	//��¼ʱ��֤�û��Ƿ����(�˺š�����)
	public Boolean checkLoginUser(String[] str) throws Exception {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		String username= str[0];
		String password= str[1];
		//�������ݿ�
		String sql= "select count(*) from user where username=? and password= ?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//��ȡ����
		pr.setString(1, username);
		pr.setString(2, password);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//�����û���������ж�
		//System.out.println(rs.getInt(1));
		if(rs.getInt(1) >= 1) {
			isOk= true;
		}else {
			isOk= false;
		}
		//System.out.println(isOk);
		
		//�ر����ݿ�
		cnn.close();
		
		return isOk;

	}
	//ע��ʱ��֤�û��Ƿ���ڣ�ע�ᡢת�ˣ�
	public Boolean checkUserName(String str) throws Exception {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		//String username= str[0];
		//String password= str[1];
		String username= str;
		//�������ݿ�
		String sql= "select count(*) from user where username=?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//��ȡ����
		pr.setString(1, username);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//�����û���������ж�
		//System.out.println(rs.getInt(1));
		if(rs.getInt(1) >= 1) {
			isOk= true;
		}else {
			isOk= false;
		}
		//System.out.println(isOk);
		
		//�ر����ݿ�
		cnn.close();
		
		return isOk;

	}
	//��ѯ��������ȡ�û����
	public String displayBalance(String usernameOne) throws Exception {
		// TODO Auto-generated method stub
		String username= usernameOne;
		//String username= "wujianbo";
		//�������ݿ�
		Connection cnn= DriverManager.getConnection(url);
		String sql= "select balance from user where username=? ";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setString(1, username);
		
		//��ȡ����
		ResultSet rs= ps.executeQuery();
		 rs.next();
		String searchResult= rs.getString(1);
		//System.out.println("�û���ǰ����ǣ�"+);
		//�ر����ݿ�
		cnn.close();
		return searchResult;

	}
	//ȡǮʱ����֤����Ƿ񹻣�ȡǮ��ת�ˣ�
	//ȡǮʱ�����û����˻������£�ȡǮ����Ǯ��ת�ˣ�
	public void updateBalance(String usernameOne, String balanceOne) throws Exception {
		// TODO Auto-generated method stub
		
		//String username= "wujianbo";
		//String balance= "444443";
		String username= usernameOne;
		String balance= balanceOne;
		Float balanceTwo= Float.parseFloat(balance);
		//�������ݿ�
		Connection cnn= DriverManager.getConnection(url);
		String sql= "update user set balance= ? where username= ?";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setFloat(1, balanceTwo);
		ps.setString(2, username);
		
		//��ȡ����
		ps.execute();
		
		//�ر����ݿ�
		cnn.close();

	}
	

}
