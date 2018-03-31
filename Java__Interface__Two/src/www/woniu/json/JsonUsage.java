package www.woniu.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonUsage ju = new JsonUsage();
		// ju.array();
		ju.mapBasic();

	}

	// java数组
	private void array() {
		// TODO Auto-generated method stub
		String[] names = { "张山", "李四", "王五", "赵六" };
		Object[] users = { "张山", "李四", "王五", "赵六", 555, true, new JsonUsage() };
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}

		for (int i = 0; i < users.length; i++) {
			System.out.println(users[i]);
		}
	}

	// java健值对
	private void mapBasic() {
		// TODO Auto-generated method stub
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		// 同学吴建波属性设置
		map1.put("name", "吴建波");
		map1.put("age", "28");
		map1.put("sex", "男");
		map1.put("weight", "56kg");
		map1.put("salsry", "10k");
		// 同学曹艳属性设置
		map2.put("name", "曹艳");
		map2.put("age", "26");
		map2.put("sex", "女");
		map2.put("weight", "50kg");
		map2.put("salsry", "13k");
		// 同学孟金波属性设置
		map3.put("name", "孟金波");
		map3.put("age", "26");
		map3.put("sex", "男");
		map3.put("weight", "60kg");
		map3.put("salsry", "9k");
		// System.out.println(map1);
		//for (Map.Entry<String, String> entry : map1.entrySet()) {
		//	System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
		//}
		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		for(int i=0; i<list.size(); i++) {
			Map<String, String> tempMap= list.get(i);
			for(Map.Entry<String, String> entry:tempMap.entrySet()) {
				System.out.print(entry.getKey() +":"+entry.getValue()+"  ");
			}
			System.out.println();
		}

	}

}
