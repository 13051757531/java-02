package com.wujianbo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestJdbcTwo {

	// ���ݿ�����������
	private String driverClassName = "com.mysl.jdbc.Driver";
	// ���ݿ������ַ���
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
 
	//���ݿ��ѯ
	private void seachData() throws Exception {
		//new com.mysql.jdbc.Driver();
		//���ݿ�����
		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement();

		System.out.println(conn);
		System.out.println(stmt);//�α�

		// ��ѯ���ݿ�
		String sql = "select count(*) from user";

		ResultSet rs = stmt.executeQuery(sql);
		
		rs.next();//�ý������λ����һ��
		System.out.println(rs.getInt(1));//��ȡ��һ�н��
		
		//�ر����ݿ�
		conn.close();
		System.out.println(rs);
		
		

	}
	
	//���ݿ��ѯ
		private void seachDataTwo() throws Exception {
			//new com.mysql.jdbc.Driver();
			//���ݿ�����
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();

			System.out.println(conn);
			System.out.println(stmt);//�α�

			// ��ѯ���ݿ�
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){//�ý������λ����һ��
				System.out.print(rs.getInt(1)+"\t");//��ȡ��һ�н��
				System.out.print(rs.getString("username")+"\t");//��ȡ��һ�н��
				System.out.print(rs.getString("phone")+"\t");//��ȡ��һ�н��
				System.out.println();
			};
			
			
			//�ر����ݿ�
			conn.close();
			System.out.println(rs);
			
			

		}

	//���ݿ����
	private void insertData() throws Exception {
		// TODO Auto-generated method stub
		//����ͬ���ݿ�����ӣ���ȡ�α�
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		
		//��������
		String sql= "insert into user values(0, 'wujianbo',  'wujianbo', '13051757531', '1154632528@qq.com')";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//�ر����ݿ�
		cnn.close();
		System.out.println("���ݿ����ɹ�");
        
	}
	
	private void psInsert() throws Exception {
		// TODO Auto-generated method stub
		//�������ݿ�
		Connection cnn= DriverManager.getConnection(url);
		//new com.mysql.jdbc.Driver();
		String sql= "insert into user(username, password, phone, email) values(?, ?, ?, ?)";
		PreparedStatement ps= (PreparedStatement)cnn.prepareStatement(sql);
		ps.setString(1, "hujiandong");
		ps.setString(2, "hujiandong");
		ps.setString(3, "13051757531");
		ps.setString(4, "1154632528@qq.com");
		
		//��������
		ps.executeUpdate();
		//�Ͽ�ͬ���ݿ������
		cnn.close();

	}

	//���ݿ����
	private void updateDate() throws Exception {
		// TODO Auto-generated method stub
		//����ͬ���ݿ������
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		//���²���
		String sql= "update user set username='wudongmei' where id='1'";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//�ر����ݿ�
		cnn.close();
		System.out.println("�������ݿ�ɹ�����");

	}

	//���ݿ��б��ɾ��
	private void deleteData() throws Exception {
		// TODO Auto-generated method stub
		//ͬ���ݿ�����
		Connection cnn= DriverManager.getConnection(url);
		Statement stmt= cnn.createStatement();
		//����ɾ��
		String sql= "delete from user where id='2'";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		//�ر����ݿ�
		cnn.close();

	}

}
