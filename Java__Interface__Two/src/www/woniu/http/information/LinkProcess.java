package www.woniu.http.information;

import java.util.ArrayList;
import java.util.List;

public class LinkProcess {
	CommonHandler ch = new CommonHandler();

	public static void main(String[] args) {
		LinkProcess lp = new LinkProcess();
		// lp.driverGetLinks();
		// lp.driverGetImage();
		// lp.driverGetInfoByLaGou();
		//lp.driver_laGouInfoGetedOnePage_V1();
		//lp.randomPageGetted_V1();
		//lp.interface__runMore();
		lp.driver_laGouInfoGetedRandomPage_V1();
	}

	// 获取页面的所有超链接
	private void driverGetLinks() {
		// TODO Auto-generated method stub
		String getUrl = "http://www.woniuxy.com/";
		// String responseByGetUrl= ch.sendGet(getUrl);
		// <a href="http://www.woniuxy.com/train/java.html#contact"
		// target="_blank">联系我们</a>
		String regex = "(<a href=\")(.*?)(\")";
		// System.out.println(responseByGetUrl);
		List<String> linkList = ch.getFidValueByRegular(getUrl, regex);
		List<String> newLinkList = new ArrayList<String>();
		// 对返回的链接数组进行处理
		for (int i = 0; i < linkList.size(); i++) {
			String tempCode = "";
			// System.out.println(linkList.get(i));
			String tempLink = linkList.get(i);
			if (tempLink.startsWith("javascript")) {
				System.out.println("这不是有效的链接");
			} else if (tempLink.startsWith("http://")) {
				// System.out.println(tempLink);
				// tempCode= ch.getResponseCodeByUrlLink(tempLink);
				// System.out.println(tempCode);
				newLinkList.add(linkList.get(i));
			} else {
				tempLink = "http://www.woniuxy.com" + tempLink;
				// System.out.println(tempLink);
				// tempCode= ch.getResponseCodeByUrlLink(tempLink);
				// System.out.println(tempCode);
				newLinkList.add(tempLink);
			}
		}

		for (int i = 0; i < newLinkList.size(); i++) {
			// System.out.println(newLinkList.get(i));
			String tempLink = newLinkList.get(i);
			String tempCode = "";
			tempCode = ch.getResponseCodeByUrlLink(tempLink);
			if (tempCode.contains("200")) {
				System.out.println(tempCode + "__正常状态码" + "____" + tempLink);
			} else {
				System.out.println(tempCode + "__不正常状态码" + "____" + tempLink);
			}

		}

	}

	// 获取页面的所有图片链接
	private void driverGetImage() {
		// TODO Auto-generated method stub
		String getUrl = "http://www.woniuxy.com/";
		// String responseByGetUrl= ch.sendGet(getUrl);
		// <a href="http://www.woniuxy.com/train/java.html#contact"
		// target="_blank">联系我们</a>
		// <img src="img/logo-white.png" /></hgroup>
		String regex = "(.*<img src=\")(.*?)(\")";
		// System.out.println(responseByGetUrl);
		List<String> linkList = ch.getFidValueByRegular(getUrl, regex);
		List<String> newLinkList = new ArrayList<String>();
		// 对返回的链接数组进行处理
		for (int i = 0; i < linkList.size(); i++) {
			String tempCode = "";
			System.out.println(linkList.get(i));
			String tempLink = linkList.get(i);
			if (tempLink.startsWith("/Picture")) {
				// System.out.println("这不是有效的链接");
				tempLink = "http://www.woniuxy.com" + tempLink;
				// System.out.println(tempLink);
				// tempCode= ch.getResponseCodeByUrlLink(tempLink);
				// System.out.println(tempCode);
				newLinkList.add(tempLink);
			} else if (tempLink.startsWith("img")) {
				tempLink = "http://www.woniuxy.com/" + tempLink;
				// System.out.println(tempLink);
				// tempCode= ch.getResponseCodeByUrlLink(tempLink);
				// System.out.println(tempCode);
				newLinkList.add(tempLink);
			}
			// else {
			// tempLink= "http://www.woniuxy.com"+tempLink;
			// System.out.println(tempLink);
			// tempCode= ch.getResponseCodeByUrlLink(tempLink);
			// System.out.println(tempCode);
			newLinkList.add(tempLink);
			// }
		}

		for (int i = 0; i < newLinkList.size(); i++) {
			// System.out.println(newLinkList.get(i));
			String tempLink = newLinkList.get(i);
			System.out.println(tempLink);
		}

	}

	// 拉钩网站信息爬取__驱动__测试模块__具体页面__所有链接
	private void driverGetInfoByLaGou() {
		// TODO Auto-generated method stub
		String laGouUrlOfCeShi = "https://www.lagou.com/zhaopin/ceshi/?";
		// String responseByCeShi= ch.sendGet(laGouUrlOfCeShi);
		// System.out.println(responseByCeShi);
		// <a href="https://www.lagou.com/gongsi/111750.html" target="_blank"
		// data-lg-tj-id="8F00" data-lg-tj-no="
		// <a class="position_link"
		// href="https://www.lagou.com/jobs/3396702.html" target="_blank"
		// data-index="3" data-lg-tj-id="8E00"
		String regex = "(.*link\" href=\")(.+?)(\")";
		List<String> linkList = ch.getFidValueByRegular(laGouUrlOfCeShi, regex);
		List<String> newLinkList = new ArrayList<String>();
		// 将链接进行重新整理
		for (int i = 0; i < linkList.size(); i++) {
			String tempLink = linkList.get(i);
			if (!tempLink.contains("{{")) {
				newLinkList.add(tempLink);
			}
		}

		List<String> employeeList = new ArrayList<String>();
		for (int i = 0; i < newLinkList.size(); i++) {
			String tempUrl = newLinkList.get(i);
			System.out.println(newLinkList.get(i));
			// <div class="company">宗盛智能研发部招聘</div>____具体公司过滤规则
			// String tempRegex= "(.*div class=\"company\">)(.+)(<.*)";
			String tempRegex = "(.*company\">)(.+)(</div.*)";
			String tempConten = ch.getVerifyValueByRegular(tempUrl, tempRegex);
			System.out.println(tempConten);
			// <span class="salary">10k-20k </span>
			String addressRegex = "(.*salary\">)(.+)(</span.*)";
			String tempSalary = ch.getVerifyValueByRegular(tempUrl, addressRegex);
			System.out.println(tempSalary);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// String workUrl= "https://www.lagou.com/jobs/2278455.html";
		// String responseByCeShi= ch.sendGet(workUrl);
		// System.out.println(responseByCeShi);
		// <span class="ceil-job">测试工程师 /</span>
		// <span class="ceil-salary">8k-15k</span>
		// for(int i=0; i<employeeList.size(); i++) {
		// System.out.println(employeeList.get(i));
		// }

	}

	// 驱动__页面信息获取__固定页面的信息获取
	private void driver_laGouInfoGetedOnePage_V1() {
		// TODO Auto-generated method stub
		String url__laGouCeShi = "https://www.lagou.com/zhaopin/ceshi/?";
		String response_ceShi = ch.sendGet(url__laGouCeShi);
		// System.out.println(response_ceShi);
		// <a href="https://www.lagou.com/gongsi/111750.html" target="_blank"
		// data-lg-tj-id="8F00" data-lg-tj-no="
		// <a class="position_link"
		// href="https://www.lagou.com/jobs/3396702.html" target="_blank"
		// data-index="3" data-lg-tj-id="8E00"
		String regex_url = "(.*link\" href=\")(.+?)(\")";
		List<String> linkList = ch.filterResponseToList(response_ceShi, regex_url);
		List<String> newLinkList = new ArrayList<String>();
		// 将链接进行重新整理
		for (int i = 0; i < linkList.size(); i++) {
			String tempLink = linkList.get(i);
			if (!tempLink.contains("{{")) {
				newLinkList.add(tempLink);
			}
		}

		List<String> employeeList = new ArrayList<String>();
		for (int i = 0; i < newLinkList.size(); i++) {
			String tempUrl = newLinkList.get(i);
			System.out.println("公司连接：" + newLinkList.get(i));
			// <div class="company">宗盛智能研发部招聘</div>____具体公司过滤规则
			// String tempRegex= "(.*div class=\"company\">)(.+)(<.*)";
			// String regex__company= "(.*company\">)(.+)(</div.*)";
			String response__companyInfo = ch.sendGet(tempUrl);
			// String response__deleteNext= response__companyInfo.replace("\n",
			// )
			String response__one = response__companyInfo.replace("<p>-", "");
			String response__two = response__one.replace("</p>", "");
			String response__three = response__two.replace("&nbsp;", "");
			String response__four = response__three.replace("<p>", "");
			String response__five = response__four.replaceAll("<a.*?>", "");
			String response__six = response__five.replace("</a> -", "");
			String response__seven = response__six.replace("</a>", "");
			String response__eiggt = response__seven.replaceAll("<span.*?>", "");
			String response__nine = response__eiggt.replace("</span>", "");
			String response__ten = response__nine.replace("\n", "");
			// String response__ten= response__nine.replace("/", "");
			String regex__companyName = "(<meta content=\")(.+?)(\" name=\".*)"; // <meta
																					// content="测试工程师,测试工程师招聘,链家网（北京）科技有限公司测试工程师招聘"
																					// name="keywords">
			String regex_salary = "( .*<div class=\"ceil-content\">)(.+?)(<div class=\"ceil-right\"></div>.*)";
			String regex_address = "(<div class=\"work_addr\">)(.+?)(查看地图)";
			String regex_responsibility = "(.*职位描述：</h3>        <div> )(.+?)(        </div>    </dd>.*)";
			String nameOfCompany = ch.filterResponseToString(response__ten, regex__companyName);
			String address_OfCompany = ch.filterResponseToString(response__ten, regex_address);
			String salary_OfCompany = ch.filterResponseToString(response__ten, regex_salary);
			String responsibity_OfUser = ch.filterResponseToString(response__ten, regex_responsibility);
			// 最后的字符串处理
			address_OfCompany = address_OfCompany.replace(" ", "");
			salary_OfCompany = salary_OfCompany.replace(" ", "");
			responsibity_OfUser = responsibity_OfUser.replace(" ", "");
			System.out.println("------公司名称是：" + nameOfCompany);
			System.out.println("------公司地址是：" + address_OfCompany);
			System.out.println("------公司薪资是：" + salary_OfCompany);
			System.out.println("------应聘技能是：" + responsibity_OfUser);
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// break;
		}
	}

	// 驱动__页面信息获取__随机页面的信息获取
	private void driver_laGouInfoGetedRandomPage_V1() {
		// TODO Auto-generated method stub
		String url__laGouCeShi = "https://www.lagou.com/zhaopin/ceshi/?";
		int pageVaue= this.randomPageGetted_V2(url__laGouCeShi);
		System.out.println("公司列表页也是："+pageVaue);
		String url__companyGeted= "https://www.lagou.com/zhaopin/ceshi/"+pageVaue+"/?filterOption="+pageVaue;
		String response_ceShi = ch.sendGet(url__companyGeted);
		// System.out.println(response_ceShi);
		// <a href="https://www.lagou.com/gongsi/111750.html" target="_blank"
		// data-lg-tj-id="8F00" data-lg-tj-no="
		// <a class="position_link"
		// href="https://www.lagou.com/jobs/3396702.html" target="_blank"
		// data-index="3" data-lg-tj-id="8E00"
		String regex_url = "(.*link\" href=\")(.+?)(\")";
		List<String> linkList = ch.filterResponseToList(response_ceShi, regex_url);
		List<String> newLinkList = new ArrayList<String>();
		// 将链接进行重新整理
		for (int i = 0; i < linkList.size(); i++) {
			String tempLink = linkList.get(i);
			if (!tempLink.contains("{{")) {
				newLinkList.add(tempLink);
			}
		}

		List<String> employeeList = new ArrayList<String>();
		for (int i = 0; i < newLinkList.size(); i++) {
			String tempUrl = newLinkList.get(i);
			System.out.println("公司连接：" + newLinkList.get(i));
			// <div class="company">宗盛智能研发部招聘</div>____具体公司过滤规则
			// String tempRegex= "(.*div class=\"company\">)(.+)(<.*)";
			// String regex__company= "(.*company\">)(.+)(</div.*)";
			String response__companyInfo = ch.sendGet(tempUrl);
			// String response__deleteNext= response__companyInfo.replace("\n",
			// )
			String response__one = response__companyInfo.replace("<p>-", "");
			String response__two = response__one.replace("</p>", "");
			String response__three = response__two.replace("&nbsp;", "");
			String response__four = response__three.replace("<p>", "");
			String response__five = response__four.replaceAll("<a.*?>", "");
			String response__six = response__five.replace("</a> -", "");
			String response__seven = response__six.replace("</a>", "");
			String response__eiggt = response__seven.replaceAll("<span.*?>", "");
			String response__nine = response__eiggt.replace("</span>", "");
			String response__ten = response__nine.replace("\n", "");
			// String response__ten= response__nine.replace("/", "");
			String regex__companyName = "(<meta content=\")(.+?)(\" name=\".*)"; // <meta
																					// content="测试工程师,测试工程师招聘,链家网（北京）科技有限公司测试工程师招聘"
																					// name="keywords">
			String regex_salary = "( .*<div class=\"ceil-content\">)(.+?)(<div class=\"ceil-right\"></div>.*)";
			String regex_address = "(<div class=\"work_addr\">)(.+?)(查看地图)";
			String regex_responsibility = "(.*职位描述：</h3>        <div> )(.+?)(        </div>    </dd>.*)";
			String nameOfCompany = ch.filterResponseToString(response__ten, regex__companyName);
			String address_OfCompany = ch.filterResponseToString(response__ten, regex_address);
			String salary_OfCompany = ch.filterResponseToString(response__ten, regex_salary);
			String responsibity_OfUser = ch.filterResponseToString(response__ten, regex_responsibility);
			// 最后的字符串处理
			address_OfCompany = address_OfCompany.replace(" ", "");
			salary_OfCompany = salary_OfCompany.replace(" ", "");
			responsibity_OfUser = responsibity_OfUser.replace(" ", "");
			System.out.println("------公司名称是：" + nameOfCompany);
			System.out.println("------公司地址是：" + address_OfCompany);
			System.out.println("------公司薪资是：" + salary_OfCompany);
			System.out.println("------应聘技能是：" + responsibity_OfUser);
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// break;
		}

	}
	
	private void randomPageGetted_V1() {
		// TODO Auto-generated method stub
		String url__ceshiHome= "https://www.lagou.com/zhaopin/ceshi/?";
		String redponse_ceShiHomeVisited= ch.sendGet(url__ceshiHome);
		//System.out.println(redponse_ceShiHomeVisited);
		String regex__pageNumber= "(<a href=\"https://www.lagou.com/zhaopin/ceshi/)(.+?)(/\" .*)";//<a href="https://www.lagou.com/zhaopin/ceshi/30/" class="page_no" data-index="30">30</a>
		List<String> list= new ArrayList<String>();
		list= ch.filterResponseToList(redponse_ceShiHomeVisited, regex__pageNumber);
		int max= 1;
		for(int i=0; i<list.size(); i++) {
			//System.out.println(list.get(i));
			int temp= Integer.parseInt(list.get(i));
			if(temp>max) {
				max= temp;
			}
		}
		//System.out.println(max);
		int index_page= (int)(Math.random()*30) + 1;
		System.out.println(index_page);
	}
	
	
	
	private int randomPageGetted_V2(String url__ceshiHomeTemp) {
		// TODO Auto-generated method stub
		//String url__ceshiHome= "https://www.lagou.com/zhaopin/ceshi/?";
		String url__ceshiHome= url__ceshiHomeTemp;
		String redponse_ceShiHomeVisited= ch.sendGet(url__ceshiHome);
		//System.out.println(redponse_ceShiHomeVisited);
		String regex__pageNumber= "(<a href=\"https://www.lagou.com/zhaopin/ceshi/)(.+?)(/\" .*)";//<a href="https://www.lagou.com/zhaopin/ceshi/30/" class="page_no" data-index="30">30</a>
		List<String> list= new ArrayList<String>();
		list= ch.filterResponseToList(redponse_ceShiHomeVisited, regex__pageNumber);
		int max= 1;
		for(int i=0; i<list.size(); i++) {
			//System.out.println(list.get(i));
			int temp= Integer.parseInt(list.get(i));
			if(temp>max) {
				max= temp;
			}
		}
		//System.out.println(max);
		int index_page= (int)(Math.random()*30) + 1;
		//System.out.println(index_page);
		return index_page;
	}
	
	private void randomPageGetted_V3() {
		// TODO Auto-generated method stub

	}
	
	
	//接口循环调用
	private void interface__runMore() {
		// TODO Auto-generated method stub
		for(int i=0; i<60; i++) {
			this.randomPageGetted_V1();
		}
	}
}
