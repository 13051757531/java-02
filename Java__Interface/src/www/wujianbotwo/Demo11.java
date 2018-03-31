package www.wujianbotwo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo11 demo11= new Demo11();
		demo11.bufferedRead();

	}
	
	public void bufferedRead() {
		// TODO Auto-generated method stub
		try {
			File file= new File("D:\\Test.txt");
			InputStream in= new FileInputStream(file);
			InputStreamReader reader= new InputStreamReader(in, "GBK");
			BufferedReader br= new BufferedReader(reader);
			String line= "";
			do {
				line= br.readLine();
				System.out.println(line);
			}while (line != null);
			br.close();
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

}
