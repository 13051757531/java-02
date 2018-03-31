package www.woniu.v7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestor {
	
	static public String mycookie = "";
	
	public void clearCookie() {
		this.mycookie = "";
	}

	// 利用Java处理HTTP的GET请求
	public String sendGet(String getUrl) {
		String line = "", body = "";
		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(getUrl);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("GET");

			// setRequestProperty主要用于设置HTTP请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", this.mycookie);
			urlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			urlConnection.setRequestProperty("Accept", "text/html");

			// 正式建立连接
			urlConnection.connect();

			this.readCookie(urlConnection);
			
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				// body = body + line + "\n";
				 body += line + "\n";
//				 body += line;
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
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("POST");

			// setRequestProperty主要用于设置HTTP请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", this.mycookie);

			// 正式建立连接并发送POST正文
			urlConnection.connect();
			
			OutputStream os = urlConnection.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.print(postData);
			pw.flush();

			//int status = urlConnection.getResponseCode(); // 获取响应的状态码
			this.readCookie(urlConnection);
			
			// 读取响应
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			while ((line = br.readLine()) != null) {
				 body += line + "\n";
//				body += line;
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
	
	public void readCookie(HttpURLConnection urlConnection) {
		Map<String, List<String>> fields = urlConnection.getHeaderFields();
		List<String> cookies = fields.get("Set-Cookie");
		if (cookies != null && cookies.size() > 0) {
			for (int i=0; i<cookies.size(); i++) {
				String cookie = cookies.get(i).split(";")[0] + ";";
				this.mycookie += cookie;
			}
		}
	}
}
