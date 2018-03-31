package www.woniu.https;

public class AgileOneProcess {
	CommonHandler ch= new CommonHandler();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgileOneProcess ap= new AgileOneProcess();
		ap.agileOneHome__Visited();
	}
	
	//首页访问
	private void agileOneHome__Visited() {
		// TODO Auto-generated method stub
		String url_agileOneHome_visited= "https://localhost/Agileone/index.php";
		String response_agileOneHome_visited= ch.sendGet(url_agileOneHome_visited);
		System.out.println(response_agileOneHome_visited);

	}
	//从首页登录网站
	private void agileOneHome__Logion() {
		// TODO Auto-generated method stub

	}
}
