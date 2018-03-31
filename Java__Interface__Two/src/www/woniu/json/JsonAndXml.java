package www.woniu.json;

public class JsonAndXml {
	CommonHandler ch= new CommonHandler();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonAndXml jm= new JsonAndXml();
		jm.address__getUser();

	}
	
	
	
	private void address__getUser() {
		// TODO Auto-generated method stub
		String url_post= "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
		String number_phone= "13051757531";
		number_phone= "130517575310";
		number_phone= "13541433525";
		//number_phone= "144";
		String data_post= "mobileCode="+number_phone+"&userID=";
		String response_AddressOfPhone= "";
		try {
			response_AddressOfPhone= ch.sendPost(url_post, data_post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(response_AddressOfPhone);
		System.out.println("=======");
		String regex_phone= "(.*：)(.+?)(</string>)";//<string xmlns="http://WebXml.com.cn/">130517575310：北京 北京 北京联通如意通卡</string>
		//String addressUser= ch.filterResponseToString(regex_phone, response_AddressOfPhone);
		String addressUser= ch.filterResponseToString(response_AddressOfPhone, regex_phone);
		System.out.println(addressUser);
	}

}
