package www.woniu.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonAndServer {
	CommonHandler ch= new CommonHandler();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsonAndServer js= new jsonAndServer();
		js.jsonAndResponse();
	}
	
	private void jsonAndResponse() {
		// TODO Auto-generated method stub
		String url__post= "http://www.woniuxy.com/SCourseByUTServlet";
		String data__post= "page=1";
		String response__post= "";
		try {
			response__post= ch.sendPost(url__post, data__post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(response__post);
				

		try {
			JSONObject jo = new JSONObject(response__post);
			//System.out.println(jo.get("name"));
			//System.out.println(jo.get("rows"));
			JSONArray ja= jo.getJSONArray("rows");
			//System.out.println(ja.length());
			for(int i=0; i<ja.length(); i++) {
				//System.out.println(ja.getString(i));
				//System.out.println(ja.get(i));
				JSONObject joT= ja.getJSONObject(i);
				System.out.println(joT.get("flag"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

	}
}
