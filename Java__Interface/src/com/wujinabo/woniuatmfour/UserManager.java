package com.wujinabo.woniuatmfour;

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
import java.util.List;
import java.util.Scanner;


public class UserManager {
	static String localUserName;
	static String localUserPassword;
	static String localUserBalance;
	static String tryUser;

	// ע�����
	public void register() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		System.out.println("======���ڽ���д����");// ��ȡ�û���Ϣ
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
		new CommonHandler().readText();
		//System.out.println(CommonHandler.udl.size());
		
		if(CommonHandler.index.equals("1")) {
			for(int i=0; i<CommonHandler.udl.size(); i++) {//�жϸ��û��Ƿ����
				if(CommonHandler.udl.get(i).contains(username)) {
					String[] str= CommonHandler.udl.get(i).split(",");
					if(str[0].equals(username)) {
						System.out.println("���ã���������û����Ѿ����ڣ����������룺");
						new UserManager().register();
					}
				}else {
					isOk= true;
				}
			}
		}else {
			isOk= true;
		}
		
		
		if(isOk) {//���û�������ʱ�����������д��
			System.out.println("���������˺����룺");
			String password = sc.next();
			System.out.println("�������˻���");
			String balance = sc.next();
	        
			String rootDir = System.getProperty("user.dir");// ��ȡ�洢�û���Ϣ���ı��ļ�
			String dataDir = rootDir + "\\data\\userdata.txt";
			// System.out.println(dataDir);
			try {
				File file = new File(dataDir); // д�����ݲ���
				OutputStream in = new FileOutputStream(file, true);
				OutputStreamWriter writer = new OutputStreamWriter(in, "GBK");
				BufferedWriter bw = new BufferedWriter(writer);
				// String content="���ǻ�����д������ݣ���\r\n";
				String contentUpdate = "\n"+username + "," + password + "," + balance + "\r\n";// �������ݸ�ʽ������
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

			System.out.println("======�ɹ����д����");
			new MainUI().mainMenu();
		}
		
	

	}

	// ��¼����
	public void login(String option) {
		// TODO Auto-generated method stub
		System.out.println("======���ã���ӭ���е�¼����");
		System.out.println("�����������û�����");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		UserManager.tryUser= username;
		
		Boolean isOk = false;
		List<String> udl = new ArrayList<String>();// ������ַ������б�����
		String rootDir = System.getProperty("user.dir");// ������ݵ��ı��ļ�
		String dataDir = rootDir + "\\data\\userdata.txt";
		// System.out.println("��");
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
			String[] uds= line.split("\n");
			for(int i=0; i<uds.length; i++) {
				if(uds[i].contains(",")) {
					udl.add(uds[i]);
					//System.out.println(uds[i]);
				}	
			}
			// System.out.println(line+"ȡֵ");
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
		for(int i=0; i<udl.size(); i++) {
			if(udl.get(i).contains(username)){
				isOk= true;
			}
		}
		
		String[] temp= new String[3];
		if(option.equals("1")) { //��ȡ��ǰ�û������˻����
			for(int i=0; i<udl.size(); i++) {
				temp= udl.get(i).split(",");
				if(temp[0].equals(UserManager.tryUser)) {
					isOk= true;
					UserManager.localUserName= temp[0];
					UserManager.localUserBalance= temp[2];
					UserManager.localUserPassword= temp[1];
				}
			}
			
		}else if(option.equals("2")) { //��ȡת���û������˻����
			for(int i=0; i<udl.size(); i++) {
				temp= udl.get(i).split(",");
			}
		}else if (option.equals("3")) { //��ȡ�����û���Ϣ
			
		}
		
		if(isOk) {//�����û����жϣ���ǰ�û���¼�ж�
			while(true) {
				System.out.println("�������������룺");
				String password= sc.next();
				if(password.equals(UserManager.localUserPassword)) {
					System.out.println("��ϲ����¼�ɹ�");
					new MainUI().subMenu();
				}else {
					System.out.println("��������������������룡��");
				}
			}
		
		}else {
			System.out.println("�Բ��������û�������������������룺");
			this.login("1");
		}
		
		
		//System.out.println(isOk);
	}
	// ���±�д�����
	// ���±���ȡ����

}
