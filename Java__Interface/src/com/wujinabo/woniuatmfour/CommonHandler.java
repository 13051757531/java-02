package com.wujinabo.woniuatmfour;

import java.io.BufferedWriter;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonHandler {
	static List<String> udl;
	static String index;
	
	//读取用户信息
	public void readText() {
		// TODO Auto-generated method stub
		Boolean isOk = false;
		CommonHandler.udl = new ArrayList<String>();// 存放行字符串的列表数组
		String rootDir = System.getProperty("user.dir");// 存放数据的文本文件
		String dataDir = rootDir + "\\data\\userdata.txt";
		// System.out.println("卡");
		try {
			File file = new File(dataDir);
			InputStream in = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(in, "GBK");
			//BufferedReader br = new BufferedReader(reader);
			String line= null;
			int temp;
			while ((temp=reader.read()) != -1) {
				if((char)temp != '\r') {
					//System.out.print((char)temp);
					line += (char)temp;
				}
				//line = (String) br.readLine();
				//System.out.println(line);
				//udl.add(line);
			}
			//br.close();
			reader.close();
			in.close();
			//System.out.println(line);
			if(line == null) {
				index= "0";
			}else {
				index= "1";
			}
			if(CommonHandler.index.equals("1")) {
				String[] uds= line.split("\n");
				for(int i=0; i<uds.length; i++) {
					if(uds[i].contains(",")) {
						udl.add(uds[i]);
						//System.out.println(uds[i]);
					}	
				}
				// System.out.println(line+"取值");
			}
			
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
		//for(int i=0; i<udl.size(); i++) {
		//	if(udl.get(i).contains(username)){
		//		isOk= true;
		//	}
		//}

	}
	
	//写入用户信息
	public void writeText(String content) {
		// TODO Auto-generated method stub
		

		String rootDir = System.getProperty("user.dir");// 获取存储用户信息的文本文件
		String dataDir = rootDir + "\\data\\userdata.txt";
		// System.out.println(dataDir);
		try {
			File file = new File(dataDir); // 写入数据操作
			OutputStream in = new FileOutputStream(file, false);
			OutputStreamWriter writer = new OutputStreamWriter(in, "GBK");
			BufferedWriter bw = new BufferedWriter(writer);
			// String content="这是缓冲区写入的内容！！\r\n";
			//String contentUpdate = "\n"+username + "," + password + "," + balance + "\r\n";// 插入数据格式化操作
			String contentUpdate = content;
			bw.write(contentUpdate, 0, contentUpdate.length());
			bw.flush();
			bw.close();
			writer.close();
			in.close();
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

		System.out.println("======成功完成写操作");
		//new MainUI().mainMenu();


	}

}
