package www.woniu.json;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class JsonAndMysql {
	String url_databaseConnect= "jdbc:mysql://localhost:3306/learn?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8"; //数据库连接字符串__java
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonAndMysql jam= new JsonAndMysql();
		//jam.dataOfDatabaseToJsonFormat__Obect();
		jam.dataOfDatabaseToJsonFormat__Array();

	}
	
	//从数据库获取数据并将数据进行json格式处理
	private void dataOfDatabaseToJsonFormat__Obect() {
		// TODO Auto-generated method stub
		Connection conn= null;
		try {
			 //conn= DriverManager.getConnection(url_databaseConnect);//建立同数据库的连接
			 conn= (Connection) DriverManager.getConnection(url_databaseConnect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(conn);
		
		String sql= "SELECT * FROM `use` WHERE 1";
		try {
			java.sql.PreparedStatement ps= conn.prepareStatement(sql);
			//System.out.println(ps);
			//System.out.println(sql);
			ResultSet rs= ps.executeQuery();
			//System.out.println(rs.getString("id"));
			ResultSetMetaData meta= (ResultSetMetaData) rs.getMetaData();
			int colCount= meta.getColumnCount();
			//System.out.println(colCount);
			//JSONObject jo= null;
			JSONObject jo= new JSONObject();
			String jsonString= "";
			while(rs.next()) {
				for(int i=1; i<=colCount; i++) {
					String colName= meta.getColumnName(i);
					//System.out.println(colName);
					//System.out.println(rs.getString(colName));
					
					//jo= new JSONObject();
					//System.out.println(rs.getString(colName));
					try {
						jo.put(colName, rs.getString(colName));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//break;
				}
				//System.out.println(jo.toString());
				jsonString += jo.toString();
			}
			System.out.println(jsonString);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	
	private void dataOfDatabaseToJsonFormat__Array() {
		// TODO Auto-generated method stub
		Connection conn= null;
		try {
			 //conn= DriverManager.getConnection(url_databaseConnect);//建立同数据库的连接
			 conn= (Connection) DriverManager.getConnection(url_databaseConnect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(conn);
		
		String sql= "SELECT * FROM `use` WHERE 1";
		try {
			java.sql.PreparedStatement ps= conn.prepareStatement(sql);
			//System.out.println(ps);
			//System.out.println(sql);
			ResultSet rs= ps.executeQuery();
			//System.out.println(rs.getString("id"));
			ResultSetMetaData meta= (ResultSetMetaData) rs.getMetaData();
			int colCount= meta.getColumnCount();
			//System.out.println(colCount);
			//JSONObject jo= null;
			JSONArray ja= new JSONArray();
			String jsonString= "";
			while(rs.next()) {
				for(int i=1; i<=colCount; i++) {
					String colName= meta.getColumnName(i);
					//System.out.println(colName);
					System.out.println(rs.getString(colName));
					
					//jo= new JSONObject();
					//System.out.println(rs.getString(colName));
				    ja.put(rs.getString(colName));
					//break;
				}
				//System.out.println(jo.toString());
				jsonString += ja.toString();
				break;
			}
			//System.out.println(jsonString);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
