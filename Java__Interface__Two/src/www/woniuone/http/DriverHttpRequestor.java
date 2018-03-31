package www.woniuone.http;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class DriverHttpRequestor {
	
	static private String url = "jdbc:mysql://localhost:3306/agileone?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";
	
	public static void main(String[] args) throws Exception {
		DriverHttpRequestor dhr= new DriverHttpRequestor();
		new HttpRequstNotice().testHome();//获取服务器分配的PHPsessionID
		new HttpRequstNotice().testLogin();//获取服务器分配的完整PHPsessionID健值对
		//dhr.DriverAdd_ByResponse();
		//dhr.driverAdd_ByDatabaseCount();
		dhr.driverAdd_ByDatabaseTitle();
		
	}
	
	//驱动__新增_需求提案
	public void driverAdd_ByResponse() throws Exception {
		// TODO Auto-generated method stubs
		Double titleID= Math.random()*10000;
		
		String postUrl= "http://localhost/Agileone/index.php/proposal/add";
		//String postData= "type=Enhancement&importance=High&headline=需求提案16&content=需求提案16&processresult=";
		//String postData= "type=&importance=&headline=需求提案22&content=需求提案22&processresult=";
		String postData= "type=&importance=&headline=需求提案"+titleID+"&content=需求提案22&processresult=";
		String ResponseAdd= new HttpRequest().sendPost(postUrl, postData);
		ResponseAdd= ResponseAdd.replace("\n", "");
		System.out.println(ResponseAdd);
		if(ResponseAdd.matches("\\d{1,10}")) {
			System.out.println();
		}else {
			System.out.println("需求提案__新增:失败");
		}
		
	}
	
	public void driverAdd_ByDatabaseCount() throws Exception{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stubs
		Double titleID= Math.random()*10000;
		String headline= "需求提案" + titleID;
		String postUrl= "http://localhost/Agileone/index.php/proposal/add";
		//String postData= "type=Enhancement&importance=High&headline=需求提案16&content=需求提案16&processresult=";
		//String postData= "type=&importance=&headline=需求提案22&content=需求提案22&processresult=";
		String postData= "type=&importance=&headline="+headline+"&content=需求提案22&processresult=";
		String ResponseAdd= new HttpRequest().sendPost(postUrl, postData);
		
		Boolean isOk= false;
		String sql= "select count(*) from proposal where headline=?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//设置查询条件
		pr.setString(1, headline);
		//pr.setString(2, password);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//获取第一列值
		//System.out.println(rs.getInt(1));
		if(rs.getInt(1) >= 1) {
			isOk= true;
		}else {
			isOk= false;
		}
		if(isOk) {
			System.out.println("需求提案__新增:成功");
		}else {
			System.out.println("需求提案__新增:失败");
		}
		
		cnn.close();
		
		
		
		

	}
	
	public void driverAdd_ByDatabaseTitle() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stubs
		Double titleID= Math.random()*10000;
		String headline= "需求提案" + titleID;
		String postUrl= "http://localhost/Agileone/index.php/proposal/add";
		//String postData= "type=Enhancement&importance=High&headline=需求提案16&content=需求提案16&processresult=";
		//String postData= "type=&importance=&headline=需求提案22&content=需求提案22&processresult=";
		String postData= "type=&importance=&headline="+headline+"&content=需求提案22&processresult=";
		String ResponseAdd= new HttpRequest().sendPost(postUrl, postData);
		ResponseAdd= ResponseAdd.replace("\n", "");
        	
		
		
		
		Boolean isOk= false;
		String sql= "select headline from proposal where proposalid=?";
		Connection cnn= DriverManager.getConnection(url);
		PreparedStatement pr= (PreparedStatement)cnn.prepareStatement(sql);
		//设置查询条件
		pr.setString(1, ResponseAdd);
		//pr.setString(2, password);
		ResultSet rs= pr.executeQuery();
		rs.next();
		//获取第一列值
		String result= rs.getString(1);
		//System.out.println(rs.getInt(1));
		if(result.contains(headline)) {
			isOk= true;
		}else {
			isOk= false;
		}
		if(isOk) {
			System.out.println("需求提案__新增:成功");
		}else {
			System.out.println("需求提案__新增:失败");
		}
		
		cnn.close();
		

	}
	
	//驱动__删除
	public void driverDelete_ByResponse() {
		// TODO Auto-generated method stub

	}
	
	public void driverDelete_ByDatabaseCount() {
		// TODO Auto-generated method stub

	}
	//驱动__查询
	public void driverQuery__ByResponse() {
		// TODO Auto-generated method stub

	}
	
	//驱动__修改
	public void DriverEdit() {
		// TODO Auto-generated method stub

	}

}
