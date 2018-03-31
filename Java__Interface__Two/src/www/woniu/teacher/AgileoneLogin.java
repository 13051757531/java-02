package www.woniu.teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AgileoneLogin {

	public static void main(String[] args) {
		AgileoneLogin login = new AgileoneLogin();
//		login.testLoginByArray();
//		login.testLoginByJDBC();
//		login.testLoginByText();
		login.forceCrack();
	}
	
	public void testLoginByArray() {
		String[][] testData = { {"admin", "wrong", "password_invalid"},
				                {"hello", "wrong", "user_invalid"},
		                        {"hello", "123456", "user_invalid"},
		                        {"admin", "admin", "successful"} };
		for (int i=0; i<testData.length; i++) {
			String username = testData[i][0];
			String password = testData[i][1];
			String expect = testData[i][2];
			boolean result = this.doLogin(username, password, expect);
			System.out.println(result);
		}
	}
	
	public void testLoginByJDBC() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/learn?"
				+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
		Connection conn = null;
		try {
			Class.forName(driverClassName).newInstance();
			conn = DriverManager.getConnection(url);
			String sql = "select username,password,expect from user";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				boolean result = this.doLogin(rs.getString(1), rs.getString(2), rs.getString(3));
				System.out.println(result);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void testLoginByText() {
		try {
			String userDir = System.getProperty("user.dir");
			File file = new File(userDir + "\\data\\testdata.csv");
			InputStream in = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				boolean result = this.doLogin(data[0], data[1], data[2]);
				System.out.println(result);
			}
			
			in.close();
			reader.close();
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean doLogin(String username, String password, String expect) {
		HttpRequestor hr = new HttpRequestor();
		String postUrl = "http://localhost/agileone/index.php/common/login";
		String postData = "username=" + username + "&password="+password+"&savelogin=true";
		String response = hr.sendPost(postUrl, postData);
		// 由于响应中包含换行符，所以无法正常使用正则表达式，先将换行符处理掉
		response = response.replace("\n", "");
		if (response.matches(".*" + expect + ".*")) {
			return true;
		}else {
			return false;
		}
	}

	public void forceCrack() {
		HttpRequestor hr = new HttpRequestor();
		String postUrl = "http://localhost/agileone/index.php/common/login";
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/learn?"
				+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
		Connection conn = null;
		try {
			Class.forName(driverClassName).newInstance();
			conn = DriverManager.getConnection(url);
			String sql = "select username,password from user";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String postData = "username=" + username + "&password="+password+"&savelogin=true";
				String response = hr.sendPost(postUrl, postData);
				if (response.contains("successful")) {
					System.out.println("暴力破解成功：用户名为：" + username + ", 密码为：" + password);
					break;
				}
				else {
					System.out.println("正在破解登录.");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
