package www.woniu.v7;

import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home$Open extends Thread {
	HttpRequestor hr= new HttpRequestor();
	static private float totalTime= 0; 
	String url$base= "http://localhost/phpwind/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Home$Open ho= new Home$Open();
//		ho.start();
		for(int i=0; i<1; i++) {
			Home$Open ho= new Home$Open();
			ho.start();
			try {ho.join();} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		System.out.println("平均时间："+totalTime/20);
	}
	
	@Override
	public void run() {
		String home$url= "http://localhost/phpwind/index.php";
		String response$home= null;
		long startTime= System.currentTimeMillis();
		try {response$home= this.hr.sendGet(home$url);} catch (Exception e) {e.printStackTrace();}
		long endTime= System.currentTimeMillis();
		float durationTime= (float)(endTime-startTime)/1000;
		this.getUrl$Css(response$home);
		this.getUrl$Js(response$home);
		this.getUrl$Gif(response$home);
		this.getUrl$Png(response$home);
		//System.out.println(response$home);
		if(response$home.contains("四川理工")) {
			System.out.println("访问页面成功;"+Thread.currentThread().getName()+";消耗时间："+durationTime+";"+this.hashCode());
		}else {
			System.out.println("访问页面失败");
		}
		
		this.totalTime+= durationTime;
	}
	
	private void getUrl$Css(String response) {
		// TODO Auto-generated method stub
		String regex= "(href=\")(.+)(.css\")";
		ArrayList<String> url$Css= this.getUrl(response, regex);
		System.out.println(url$Css.size());
	    for(int i=0; i<url$Css.size(); i++) {
	    	System.out.println(this.url$base+url$Css.get(i)+".css");
	    }

	}
	
	private void getUrl$Js(String response) {
		// TODO Auto-generated method stub
		String regex= "(src=\")(.+)(.js\")";
		ArrayList<String> url$js= this.getUrl(response, regex);
		System.out.println(url$js.size());
	    for(int i=0; i<url$js.size(); i++) {
	    	System.out.println(this.url$base+url$js.get(i)+".js");
	    }

	}
	
	private void getUrl$Gif(String response) {
		// TODO Auto-generated method stub
		String regex= "(src=\")(.+)(.gif\")";
		ArrayList<String> url$Gif= this.getUrl(response, regex);
		System.out.println(url$Gif.size());
	    for(int i=0; i<url$Gif.size(); i++) {
	    	System.out.println(this.url$base+url$Gif.get(i)+".gif");
	    }

	}
	
	private void getUrl$Png(String response) {
		// TODO Auto-generated method stub
		String regex= "(src=\")(.+)(.png\")";
		ArrayList<String> url$Gif= this.getUrl(response, regex);
		System.out.println(url$Gif.size());
	    for(int i=0; i<url$Gif.size(); i++) {
	    	System.out.println(this.url$base+url$Gif.get(i)+".png");
	    }

	}
	
	
	private ArrayList<String> getUrl(String response, String regex) {
		// TODO Auto-generated method stub
		//String regex= "(href=\")(.+)(.css\")";
		//String regex= "(href=\")(.+)(gif\")";
		ArrayList<String> data= new ArrayList<String>();
		Pattern p= Pattern.compile(regex);
		Matcher m= p.matcher(response);
		while(m.find()) {
			if(!data.contains(m.group(2))) {
				data.add(m.group(2));
			}
		}
	    return data;             
	}
	

}












