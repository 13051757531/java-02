package www.woniu.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestorOld {

	public static void main(String[] args) {
		HttpRequestor hr = new HttpRequestor();
		
		// 发送GET请求，打开首页，并进行断言
		String respHome = hr.sendGet("http://localhost/agileone/");
		if (respHome.contains("出错啦: 用户名不能为空")) {
			System.out.println("打开登录页面：成功.");
		}
		else {
			System.out.println("打开登录页面：失败.");
		}
		
		// 发送POST请求，实现登录，并进行断言
		String postUrl = "http://localhost/agileone/index.php/common/login";
		String postData = "username=admin&password=admin&savelogin=true";
		String respLogin = hr.sendPost(postUrl, postData);
		if (respLogin.contains("successful")) {
			System.out.println("登录的验证：成功.");
		}
		else {
			System.out.println("登录的验证：失败.");
		}
		
//		String postUrl2 = "http://localhost/agileone/index.php/common/login";
//		String postData2 = "username=admin123&password=admin&savelogin=true";
//		String respLogin2 = hr.sendPost(postUrl2, postData2);
//		if (respLogin2.contains("user_invalid")) {
//			System.out.println("登录的验证：成功.");
//		}
//		else {
//			System.out.println("登录的验证：失败.");
//		}
	}

	// 利用Java处理HTTP的GET请求
	public String sendGet(String getUrl) {
		String line = "", body = "";
		HttpURLConnection urlConnection = null;
		
		try {
			URL url = new URL(getUrl);
			urlConnection = (HttpURLConnection)url.openConnection();
			
			// 本次连接相关的参数设置
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("GET");
			
			// setRequestProperty主要用于设置HTTP请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", "MyCookieValue");
			urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("Accept", "text/html");
			
			// 正式建立连接
			urlConnection.connect();
			
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				// body = body + line + "\n";
				body += line + "\n";
			}
			
			// 关闭流，关闭连接
			br.close();
			isr.close();
			is.close();
			urlConnection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return body;
	}
	
	
	// 利用Java代码实现POST请求
	public String sendPost(String postUrl, String postData) {
		String line = "", body = "";
		
		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(postUrl);
			urlConnection = (HttpURLConnection)url.openConnection();
			
			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("POST");
			
			// setRequestProperty主要用于设置HTTP请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", "MyCookieValue");
			
			// 正式建立连接并发送POST正文
			urlConnection.connect();
			OutputStream os = urlConnection.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.print(postData);
			pw.flush();
			
			// 读取响应
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				body += line + "\n";
			}
			
			// 关闭流，关闭连接
			br.close();
			isr.close();
			is.close();
			urlConnection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return body;
	}
}