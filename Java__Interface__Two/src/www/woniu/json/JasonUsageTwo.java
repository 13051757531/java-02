package www.woniu.json;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JasonUsageTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JasonUsageTwo ju = new JasonUsageTwo();
		// ju.stringToObject();
		// ju.stringToArrayObject();
		//ju.stringToArray();
		ju.jsonValueIsObject();

	}

	// 字符串转对象健值对
	private void stringToObject() {
		// TODO Auto-generated method stub
		String source = "{'name':'吴建波', 'age':'28', 'weight':'56kg', 'phone':'13051757531', 'height':'170'}";
		try {
			JSONObject jb = new JSONObject(source);
			System.out.println(jb.get("name"));
			System.out.println(jb.get("age"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 字符串转数组+对象键值对
	private void stringToArrayObject() {
		// TODO Auto-generated method stub
		String sourceTwo = "[" + "{'name':'吴建波', 'age':'28', 'sex':'男'}, " + "{'name':'王磊', 'age':'22', 'sex':'男'}, "
				+ "{'name':'曹艳', 'age':'26', 'sex':'女'}, " + "{'name':'阳刚', 'age':'25', 'sex':'男'}, "
				+ "{'name':'曹刚', 'age':'24', 'sex':'男'}" + "]";
		try {
			JSONArray ja = new JSONArray(sourceTwo);
			for (int i = 0; i < ja.length(); i++) {
				// System.out.println(jo.getJSONObject(i));
				JSONObject jo = ja.getJSONObject(i);
				System.out.print(jo.get("name"));
				System.out.println(jo.get("age"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 字符串转数组
	private void stringToArray() {
		// TODO Auto-generated method stub
		String sourceThree = "['wujinabo', 'yanggang', 'caoyan', 'wangpeng']";
		try {
			JSONArray jo = new JSONArray(sourceThree);
			System.out.println(jo.length());
			for (int i = 0; i < jo.length(); i++) {
				System.out.println(jo.get(i));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// json对象健值的value为健值对
	private void jsonValueIsObject() {
		// TODO Auto-generated method stub
		Map<String, String> user1= new HashMap<String, String>();
		Map<String, String> user2= new HashMap<String, String>();
		JSONObject jo= new JSONObject();
		user1.put("name", "吴建波");
		user1.put("age", "28");
		user1.put("sex", "男");
		user1.put("phone", "13051757531");
		
		user2.put("name", "曹艳");
		user2.put("age", "26");
		user2.put("sex", "女");
		user2.put("phone", "13051757532");
		
		try {
			jo.put("user1", user1);
			jo.put("user2", user2);
			System.out.println(jo.get("user1"));
			JSONObject joT= jo.getJSONObject("user1");
			System.out.println(joT.get("phone"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
