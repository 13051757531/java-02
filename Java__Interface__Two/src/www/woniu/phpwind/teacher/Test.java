package www.woniu.phpwind.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	HttpRequestor hr = new HttpRequestor();
	
	public static void main(String[] args) {
		Test t = new Test();
//		String response = t.hr.sendGet("http://localhost/phpwind/");
//		System.out.println(response);
		String response = "read.php?tid=1234&page=e#awvxcvread.php?tid=12346&page=e#a";
		//List<String> list = t.getItems(response, ".*(read.php\\?tid=)(.+)(&page=e#a).*");
		List<String> list = t.getItems(response, "(.*tid=)(.+)(&pag.*)");
		System.out.println(list.size());
	}
	
	
	
	private List<String> getItems(String response, String regex) {
		List<String> items = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		System.out.println(m.find()+"nn");
		System.out.println("aa");
		if (m.find()) {
			items.add(m.group(2));
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		if(m.find()) {
			System.out.println("aab");
		}
		
		return items;
	}

}
