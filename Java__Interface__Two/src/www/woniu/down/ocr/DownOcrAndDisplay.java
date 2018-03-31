package www.woniu.down.ocr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DownOcrAndDisplay {

	FileUpAndDown fad= new FileUpAndDown();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DownOcrAndDisplay dd= new DownOcrAndDisplay();
		//dd.downOcr();
		
		dd.recognizeOcr("D:\\ocr_image\\112.png", false);
		dd.recognizeOcr("D:\\ocr_image\\113.png", false);
		dd.recognizeOcr("D:\\ocr_image\\114.png", false);
		dd.recognizeOcr("D:\\ocr_image\\115.png", false);
		dd.recognizeOcr("D:\\ocr_image\\116.png", false);
		dd.recognizeOcr("D:\\ocr_image\\117.png", false);

	}

	
	
	public void downOcr() {
		// TODO Auto-generated constructor stub
		
		for(int i=0; i<20; i++) {
			String url_ocr= "http://www.woniuxy.com/PictureCheckCodeServlet";
			String path_down= "D:\\ocr_image\\";
			fad.fileDown_one(url_ocr, path_down);
			System.out.println("第__"+i+"张验证码下载成功");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void recognizeOcr(String imageFile, boolean isChinese) {
		// TODO Auto-generated method stub
		String result= "";
		String path_image= imageFile;
		String path_tessertactExe= "C:\\Tesseract-OCR\\tesseract.exe";
		String path_outPut= "d:\\out";
		String command= path_tessertactExe+" "+path_image+" "+path_outPut;
		if(isChinese) {
			command += " -l chi_sim";
		}else {
			command += " -l eng";
		}
		
		//System.out.println(command);
		Process process= null;
		try {
			process = Runtime.getRuntime().exec(command);
			int exeCode= process.waitFor();
			if(exeCode == 0) {
				InputStream fis= new FileInputStream(path_outPut+".txt");
				InputStreamReader isr= new InputStreamReader(fis, "UTF-8");
				BufferedReader br= new BufferedReader(isr);
				result= br.readLine();
				br.close();
			}else {
				System.out.println("本次识别：失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		
	}
}
