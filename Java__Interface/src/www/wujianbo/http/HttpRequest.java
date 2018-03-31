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
	//����get����__��������__������
	private void dataDriverSendGet() throws Exception {
		// TODO Auto-generated method stub
		String[] dataOne= {"http://localhost/Agileone/", "������: �û�������Ϊ��", "Ageleone_sendGet__����վ��ҳ_����"};
		String[] dataTwo= {"http://localhost/Agileon/", "���Ӳ�����", "Ageleone_sendGet__����վ��ҳ_����"};
		List<String[]> list= new ArrayList<String[]>();
		list.add(dataOne);
		list.add(dataTwo);
		for(int i=0; i<list.size(); i++){
			//String[] (List)temp= (List)list[i];
			this.driverSendGet(list.get(i));
		}

	}
	//����get����__��������
	private void driverSendGet(String[] list) throws Exception {
		// TODO Auto-generated method stub
		//String getUrl= "http://localhost/Agileon/";
		String getUrl= list[0];
		String respect= list[1];
		String caseName= list[2];
		String response= this.sendGet(getUrl);
		//System.out.println(response);
		if(response.contains(respect)) {
			System.out.println(caseName + "��ִ�гɹ�");
		}else{
			System.out.println(caseName + "��ִ��ʧ��");
		}

	}
	
	//����get����
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
			
			//������ز�������
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("GET");
			//urlConnection.set
			
			//���������ͷ����Ϣ
			urlConnection.setRequestProperty("User-Agent", "Java-Client");
			urlConnection.setRequestProperty("Cookie", "MyCookieValue");
			
			//����url����������
			urlConnection.connect();
			
			InputStream is= urlConnection.getInputStream();//��ȡ����ҳ����ֽ���
			InputStreamReader isr= new InputStreamReader(is, "utf-8");//���ֽ���ת����ֽ���
			BufferedReader br= new BufferedReader(isr);//�ӻ����ȡ�ֽ���
			
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
				return bodyTwo= "���Ӳ�����";
			}else {
				return body;
			}
			
		}
	}
	
	
	// ����post����__��������__������
	private void dataDriverSendPost() throws Exception {
		// TODO Auto-generated method stub
		String[] dataOne= {"http://localhost/Agileone/index.php/common/login", "username=admin&password=admin&savelogin=true��", "successful", "Ageleone_sendPost__�û���¼_����"};
		String[] dataTwo= {"http://localhost/Agileone/index.php/common/login", "username=admi&password=admin&savelogin=true��", "user_invalid", "Ageleone_sendPost__�û���¼_�û�������"};
		String[] dataThree= {"http://localhost/Agileone/index.php/common/login", "username=admin&password=admn&savelogin=true��", "password_invalid", "Ageleone_sendPost__�û���¼_�������"};


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
	// ����post����__��������
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
			System.out.println(caseName+"��ִ�гɹ�");
		}else {
			System.out.println(caseName+"��ִ��ʧ��");
		}
		
		//user_invalid
		//password_invalid

	}

	// ����post����
	public String sendPost(String postUrl, String postData) throws Exception {
		// TODO Auto-generated method stub
		//String postUrl= "http://localhost/Agileone/index.php/common/login";
		//String postData= "username=admin&password=admin&savelogin=true";
		String line= "";
		String body= "";
		URL url= new URL(postUrl);
		HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
		
		//������ز�������
		urlConnection.setDoOutput(true);
		urlConnection.setConnectTimeout(10000);
		urlConnection.setReadTimeout(10000);
		urlConnection.setUseCaches(false);
		urlConnection.setRequestMethod("POST");
		
		//���������ͷ����Ϣ
		urlConnection.setRequestProperty("User-Agent", "Java-Client");
		urlConnection.setRequestProperty("Cookie", "MyCookieValue");
		
		//��ʽ��������
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
