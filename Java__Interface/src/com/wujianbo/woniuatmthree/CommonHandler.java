package com.wujianbo.woniuatmthree;

import java.util.*;
import java.io.BufferedReader;
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

public class CommonHandler {
	
	// �������ı��ļ�д�����ݣ�true׷��д������,fale���д������
		public void writeText(String content, Boolean isOk) {
			// TODO Auto-generated method stub
			Boolean isOkTwo= isOk;
			String path = "D:\\workspace\\Java\\data\\userdata.txt";
			String rootDir = System.getProperty("user.dir");
			String dataDir = rootDir + "\\data\\userdata.txt";
			// System.out.println(dataDir);
			try {
				File file = new File(dataDir);          //д�����ݲ���
				OutputStream in = new FileOutputStream(file, isOk);
				OutputStreamWriter writer = new OutputStreamWriter(in, "UTF-8");
				BufferedWriter bw = new BufferedWriter(writer);
				bw.write(content, 0, content.length());
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
			System.out.println("�û���Ϣд��ɹ�����");
			if(isOkTwo){
				new MainUI().mainMenu();//��ת��ϵͳ������
			}else {
				new MainUI().subMenu();//��ת�������˻�����
			}
			
		}

		
		
		//�������ı��ļ���ȡ����,1����Ե�ǰ�û����ݽ��ж�ȡ��2�����ת���û����ݶ�ȡ��3����������û����ݶ�ȡ
		public void ReadText(String username,String option) {
			// TODO Auto-generated method stub
			String rootDir = System.getProperty("user.dir");
			String dataDir = rootDir + "\\data\\userdata.txt";
			//System.out.println("��");
			try {
				File file= new File(dataDir);
				InputStream in= new FileInputStream(file);
				InputStreamReader reader= new InputStreamReader(in, "GBK");
				BufferedReader br= new BufferedReader(reader);
				String line= "";
				String[] temp= new String[3];
				//System.out.println(line.length());
				while(br.readLine() != null) {
					//System.out.println("��");
					line= (String)br.readLine();
					//System.out.println(line+"ȡֵ");
					//System.out.println(line);
					//System.out.println(line.length());
					if(line != null) {
						temp= line.split(",");
					}
				
					//line+= line;
					//line+= ";";
					if(temp[0].equals(username)) {      //���嵥���û����ݻ�ȡ
						if(option.equals("1")) {
							//System.out.println("��ǰ����ִ��");
							UserManager.localUserName= temp[0];
							UserManager.localUserPassword= temp[1];
							UserManager.localUserAccountBalance= temp[2];
						}
						if(option.equals("2")) {
							UserManager.otherUserName= temp[0];
							UserManager.otherUserAccountBalance= temp[2];
						}
					}
					if(option.equals("3")) {
						//System.out.println(line);
						line= ";" +line + ";";
						UserManager.allData +=line;
						//allData+= line;
					}
					//System.out.println(line);
				}
				
				br.close();
				reader.close();
				in.close();
				//System.out.println(line+"ȡֵ");
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
		
		//���ܵ��û����ݽ��д���
		public String processData(String usernameT, double balance, String data) {
			// TODO Auto-generated method stub
			double updateBalnace= balance;
			String updateBalnaceTwo= updateBalnace+"";
			String username= usernameT;
			String temp= "null;kkk,lll,333.9;;wjb,wjb,444.0;;jkll,jl,55.0;;jkl,ll,9999.0;;null;";
			temp= data;
			//double balance= 19999.0;
			//String 
			String[] arr= temp.split(";");
			String[] tempTwo;
			String[] tempFour;
			List<String> one= new ArrayList<String>();
			List<String> two= new ArrayList<String>();
			for(int i=0; i<arr.length; i++) {  //����������
				if(arr[i].equals("null")) {
					//System.out.println(arr[i]);
				}else {
					//System.out.println(arr[i]);
					//tempTwo= arr[i].split(",");
					one.add(arr[i]);
				}
				
			}
			for(int i=0; i<one.size();i++) {   //���ݸ���
				if(one.get(i).contains(username)) {
					String tempString= one.get(i);
					tempFour= tempString.split(",");
					for(int j=0; j<tempFour.length; j++) {
						two.add(tempFour[j]);
					}
					two.set(2, updateBalnaceTwo);
					String tempFive= two.get(0) +","+ two.get(1) +","+ two.get(2);
					one.set(i, tempFive);
				}
				
			}
			
			String totalString= "";
			for(int i=0; i<one.size();i++) {//������װ
				String tempSeven= one.get(i);
				tempSeven= tempSeven + "\r\n";
 				totalString+= tempSeven;
			}
			
			//System.out.println(totalString);
			return totalString;

		}
		
		//��ע�����ݽ����ַ������Ӵ���
		public void connectData(String username, String password, double salary) {
			// TODO Auto-generated method stub
			//content= 

		}

}
