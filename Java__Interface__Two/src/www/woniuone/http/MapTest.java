package www.woniuone.http;
import java.util.*;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("name", "吴建波");
		map.put("email", "1154632528@qq.com");
		map.put("phone", "13051757531");
		System.out.println(map.get("name"));
		for(int i=0; i<map.size(); i++) {
			System.out.println(map.size());
		}
	}

}
