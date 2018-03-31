package www.wujianbo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.URIResolver;


public class HttpRequest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		HttpRequest hr= new HttpRequest();
		//hr.driverSendGet();
		//hr.dataDriverSendGet();
		//hr.sendPost();
		//hr.driverSendPost();
		hr.dataDriverSendPost();
	}
	//发送get请求__驱动程序__参数化
	private void dataDriverSendGet() throws Exception {
		// TODO Auto-generated method stub
		String[] dataOne= {"http://localhost/Agileone/", "出错啦: 用户名不能为空", "Ageleone_sendGet__打开网站首页_正向"};
		String[] dataTwo= {"http://localhost/Agileon/", "链接不存在", "Ageleone_sendGet__打开网站首页_反向"};
		List<String[]> list= new ArrayList<String[]>();
		list.add(dataOne);
		list.add(dataTwo);
		for(int i=0; i<list.size(); i++){
			//String[] (List)temp= (List)list[i];
			this.driverSendGet(list.get(i));
		}

	}
	//发送get请求__驱动程序
	private void driverSendGet(String[] list) throws Exception {
		// TODO Auto-generated method stub
		//String getUrl= "http://localhost/Agileon/";
		String getUrl= list[0];
		String respect= list[1];
		String caseName= list[2];
		String response= this.sendGet(getUrl);
		//System.out.println(response);
		if(response.contains(respect)) {
			System.out.println(caseName + "：执行成功");
		}else{
			System.out.println(caseName + "：执行失败");
		}

	}
	
	//发送get请求
	private String sendGet(String getUrl) throws Exception {
		String bodyTwo= "";
		String body= "";
		int i= 0;
		try {
			// TODO Auto-generated method stub
			String line= "";
			//String getUrl= "http://localhost/Agileone/";
			//HttpURLConnection urlConnection= null;
			URL url= new URL(getUrl);
			System.out.println(url);
			HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
			//urlConnection= (HttpURLConnection)url.openConnection();
			System.out.println(urlConnection);
			
			//连接相关参数设置
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("GET");
			//urlConnection.set
			
			//设置请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", "MyCookieValue");
			
			//发送url，建立连接
			urlConnection.connect();
			
			InputStream is= urlConnection.getInputStream();//获取返回页面的字节码
			InputStreamReader isr= new InputStreamReader(is, "utf-8");//将字节码转变成字节流
			BufferedReader br= new BufferedReader(isr);//从缓存获取字节流
			
			while((line=br.readLine())!=null) {
				body= body + line + "\n";
			}
			//System.out.println(body);
			i++;
			return body;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(i == 0) {
				return bodyTwo= "链接不存在";
			}else {
				return body;
			}
			
		}
	}
	
	
	// 发送post请求__驱动程序__参数化
	private void dataDriverSendPost() throws Exception {
		// TODO Auto-generated method stub
		String[] dataOne= {"http://localhost/Agileone/index.php/common/login", "username=admin&password=admin&savelogin=true空", "successful", "Ageleone_sendPost__用户登录_正向"};
		String[] dataTwo= {"http://localhost/Agileone/index.php/common/login", "username=admi&password=admin&savelogin=true空", "user_invalid", "Ageleone_sendPost__用户登录_用户名错误"};
		String[] dataThree= {"http://localhost/Agileone/index.php/common/login", "username=admin&password=admn&savelogin=true空", "password_invalid", "Ageleone_sendPost__用户登录_密码错误"};


		List<String[]> list= new ArrayList<String[]>();
		list.add(dataOne);
		list.add(dataTwo);
		list.add(dataThree);
		for(int i=0; i<list.size(); i++){
			//String[] (List)temp= (List)list[i];
			//this.driverSendGet(list.get(i));
			this.driverSendPost(list.get(i));
		}
		

	}
	// 发送post请求__驱动程序
	private void driverSendPost(String[] list) throws Exception {
		// TODO Auto-generated method stub
		//String postUrl= "http://localhost/Agileone/index.php/common/login";
		//String postData= "username=admin&password=admin&savelogin=true";
		String postUrl= list[0];
		String postData= list[1];
		String respect= list[2];
		//System.out.println(respect);
		String caseName= list[3];
		String response= this.sendPost(postUrl, postData);
		//System.out.println(response);
		if(response.contains(respect)) {
			System.out.println(caseName+"：执行成功");
		}else {
			System.out.println(caseName+"：执行失败");
		}
		
		//user_invalid
		//password_invalid

	}

	// 发送post请求
	public String sendPost(String postUrl, String postData) throws Exception {
		// TODO Auto-generated method stub
		//String postUrl= "http://localhost/Agileone/index.php/common/login";
		//String postData= "username=admin&password=admin&savelogin=true";
		String line= "";
		String body= "";
		URL url= new URL(postUrl);
		HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
		
		//连接相关参数设置
		urlConnection.setDoOutput(true);
		urlConnection.setConnectTimeout(10000);
		urlConnection.setReadTimeout(10000);
		urlConnection.setUseCaches(false);
		urlConnection.setRequestMethod("POST");
		
		//设置请求的头部信息
		urlConnection.setRequestProperty("User-Agent", "Java-Client");
		urlConnection.setRequestProperty("Cookie", "MyCookieValue");
		
		//正式建立连接
		urlConnection.connect();
		OutputStream os= urlConnection.getOutputStream();
		PrintWriter pw= new PrintWriter(os);
		pw.print(postData);
		pw.flush();
		
		InputStream is= urlConnection.getInputStream();
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		while((line=br.readLine())!=null) {
			body+= line + "\n";
		}
		
		//System.out.println(body);
		br.close();
		isr.close();
		is.close();
		urlConnection.getHeaderFields();
		return body;
		

	}

}
