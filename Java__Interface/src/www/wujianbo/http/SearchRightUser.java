package www.wujianbo.http;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

public class SearchRightUser {
	static String userName= "";
	static String userPasserword= "";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SearchRightUser sru= new SearchRightUser();
		//sru.driverSearchUser();
		//sru.getUserData();
		sru.dataDriverSearchUser();

	}
	
	//����ȷ���û���__����������
	private void dataDriverSearchUser() throws Exception {
		// TODO Auto-generated method stub
		List<String[]> listTwo= new ArrayList<String[]>();
		String[] userData= {"", ""};
		String file= "D:\\workspace\\Java\\src\\www\\wujianbo\\http\\UserData.txt";
		List<String[]> result= this.getUserData(file);
		for(int i=0; i<result.size(); i++) {
			userData[0]= "http://localhost/Agileone/index.php/common/login";
			userData[1]= "username="+result.get(i)[0]+"&password="+result.get(i)[1]+"&savelogin=true";
			this.driverSearchUser(userData[0], userData[1]);
		}
	}
	
	//����ȷ���û���__��������
	private void driverSearchUser(String postUrl, String postData) throws Exception {
		// TODO Auto-generated method stub
		//String postUrl= "http://localhost/Agileone/index.php/common/login";
		//String postData= "username=admin&password=admin&savelogin=true";
		//String postUrl= data[0];
		//String postData= data[1];
		String response= new HttpRequest().sendPost(postUrl, postData);
		if(response.contains("successful")) {
			System.out.print("��¼�ɹ���");
			System.out.println("�û���ϢΪ" + postData);
		}else {
			System.out.print("��¼ʧ�ܣ�");
			System.out.println("�û���ϢΪ" + postData);
		}
	}
	
	
	//����ȷ���û���__��ȡ�Զ���������û���Ϣ
	private List<String[]> getUserData(String file) throws Exception {
		// TODO Auto-generated method stub
		String line= "";
		String data= "";
		List<String[]> list= new ArrayList<String[]>();
		String[] userData= {"", ""};
		
		//String file= "D:\\workspace\\Java\\src\\www\\wujianbo\\http\\UserData.txt";
		BufferedReader br= new BufferedReader(new FileReader(file));
		//System.out.println(br.readLine());
		while((line= br.readLine())!=null) {
			//data+= line;
			userData= line.split(":");
			list.add(userData);
		}
        //System.out.println(list);
		return list;

	}
}
