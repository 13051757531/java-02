package www.wujianbotwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo09 demo09= new Demo09();
		//demo09.byteRead();
		demo09.byteWrite();
		demo09.byteWriteFalse();

	}
	
	private void byteRead() {
		try {
			File file= new File("D:\\Test.txt");
			InputStream in= new FileInputStream(file);
			byte[] buf= new byte[(int)file.length()];
			in.read(buf);
			in.close();
			for(byte b: buf) {
				System.out.println(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private void byteWrite() {
		try {
			File file= new File("D:\\Test.txt");
			OutputStream out= new FileOutputStream(file, true);
			String content= "这是文件内容。\r\n";
			byte[] buf= content.getBytes();
			out.write(buf, 0, buf.length);
			out.close();
			System.out.println("输入成功！！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private void byteWriteFalse() {
		try {
			File file= new File("D:\\Test.txt");
			OutputStream out= new FileOutputStream(file, false);
			String content= "这是文件内容。\r\n";
			byte[] buf= content.getBytes();
			out.write(buf, 0, buf.length);
			out.close();
			System.out.println("输入成功！！");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
