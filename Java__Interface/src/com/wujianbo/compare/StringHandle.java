package com.wujianbo.compare;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class StringHandle{
	
	// �ӿ���̨�����ַ���
	public Integer[] inputString() {
		Integer[] result;
		System.out.println("������һ���ַ�����");
		Scanner sc = new Scanner(System.in);
		String source = sc.nextLine();
        if (source.length() < 1) {
        	// ����ǿ���˳����⣬��û�и��õĽ���취��
        	System.out.println("������벻�Ϸ�����ǿ���˳�.");
        	System.exit(1);
        	result = null;
        	
        }
        else {
        	Integer[] array = this.splitString(source, ",");
        	if (Arrays.equals(array, null))
        		System.out.println("���벻�Ϸ�");
        	result = array;
        }
        return result;
	}
	
	// ���ַ�������������
	// ģ��ʵ���ַ���������split��Ϊ������ԣ�����ʵ�� 
	public Integer[] splitString(String source, String delimiter) {
		Vector<Integer> vector = new Vector<Integer>();
		int position = source.indexOf(delimiter);
		while (source.contains(delimiter)) {
			String value = source.substring(0, position);
			if (this.isNumber(value)) {
				vector.add(Integer.parseInt(value));
			}
			else {
				System.out.println("������벻�Ϸ�����ǿ���˳�.");
	        	System.exit(1);
	        	// �������ǿ���˳�����Ҳ��������һ���ر��ֵ����˵�����벻�Ϸ�
				// Integer[] result = {11111};
				// return result;
			}
			source = source.substring(position + 1, source.length());
			position = source.indexOf(delimiter);
		}
		vector.add(Integer.parseInt(source));
		Integer[] array = new Integer[vector.size()];
		vector.copyInto(array);
		return array;
	}
	
	// ����ַ����Ƿ������ת��Ϊ����
	public boolean isNumber(String source) {
		int minus = 0;	// ͳ�Ƹ��ŵĸ���
		int point = 0;	// ͳ��С����ĸ���
		if(source == ""){
			return false;
		}
		if(source == null) {
			return false;
		}else {
			for(int i=0; i<source.length(); i++){
				int code = source.charAt(i);	// ��ȡÿ���ַ���ASCII��
				// ���ĳ���ַ�������0-9�򸺺Ż�С���㣬������ж�Ϊ��Ч����
				if (code<45 || code > 57 || code == 47) 
					return false;
				
				// ͳ���ַ����и��ź�С����ĸ���
				if(code == 45) minus++;
				if(code == 46) point++;		
			}
		}
		
		// ����ַ����еĸ��Ż�С���㳬��1��������Ч
		if(minus > 1 || point > 1) return false;
		// ����и��ţ����Ǹ��Ų��ڵ�һλ������Ч
		if(minus == 1 && source.charAt(0) != 45) return false;
		// �����С���㣬����С���������һλ������Ч
		if(point == 1 && source.charAt(source.length()-1) == '.') return false;
		
		// ������������δ���֣���˵������ȷ������
		return true;
	}
}