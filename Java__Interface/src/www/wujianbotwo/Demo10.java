package www.wujianbotwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo10 demo10= new Demo10();
		//demo10.charRead();
		//demo10.charWrite();
		demo10.charWriteTwo();

	}
	public void charRead() {
		try {
			File file= new File("D:\\Test.txt");
			InputStream in= new FileInputStream(file);
			InputStreamReader reader= new InputStreamReader(in, "GBk");
			int temp;
			do {
				
				temp= reader.read();
				if((char)temp != '\r') {
					System.out.print((char)temp);
				}
				
			}while(temp != -1);
			//while((temp=reader.read()) != -1) {
			//	if((char)temp != '\r') {
			//		System.out.print((char)temp);
			//	}
			//}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void charWrite() {
		try {
			File file= new File("D:\\Test.txt");
			OutputStream in= new FileOutputStream(file, true);
			OutputStreamWriter out= new OutputStreamWriter(in, "GBK");
			String conten= "我要回家。\r\n";
			char[] ch= conten.toCharArray();
			out.write(ch, 0, ch.length);
			out.flush();
			out.close();
			System.out.println("写入成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void charWriteTwo() {
		try {
			File file= new File("D:\\Test.txt");
			OutputStream in= new FileOutputStream(file, false);
			OutputStreamWriter out= new OutputStreamWriter(in, "GBK");
			String conten= "我要回家。\r\n";
			char[] ch= conten.toCharArray();
			out.write(ch, 0, ch.length);
			out.flush();
			out.close();
			System.out.println("写入成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

























