package com.wujianbo;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Demo12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo12 demo12= new Demo12();
		
		int[] numbers= {23, 77, 66, 44, 88};
		//Boolean result= demo12.dicordNunberCheck(numbers, 99);
		//System.out.println(result);
		int[] numbersTwo= {1, 2, 3, 4, 5, 6};
		demo12.orderNumberHalfSearch(numbersTwo, 99);;

	}
	
	//��������Ĳ���
	public Boolean dicordNunberCheck(int[] numbers, int value) {
		//23��77,66,44,88
		//int value= 23;
		Boolean isOk= false;
		//int[] numbers= {23, 77, 66, 44, 88};
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == value) {
				isOk= true;
				break;
				//System.out.println("���ҵ�������������");
			}else{
				isOk= false;
				//System.out.println("���ҵ���������");
			}
		}
		//System.out.println(isOk);
		return isOk;
	}
	
	//��������Ĳ���
	public void orderNumberHalfSearch(int[] numbers, int value) {
		//int[] numbers= {1, 2, 3, 4, 5, 6};
		//int value= 7;
		int minIndex= 0;
		int maxIndex= numbers.length - 1;
		Boolean isOk= false;
		//System.out.println(maxIndex);
		while(minIndex <= maxIndex) {
			int middleIndex= (minIndex+maxIndex)/2;
			//System.out.println(middleIndex+"aa");
			//�����ұ�
			if(numbers[middleIndex] < value) {
				minIndex= middleIndex + 1;
				//System.out.println(minIndex);
				//�������
			}else if(numbers[middleIndex] > value) {
				maxIndex= middleIndex - 1;
			}
			else if(numbers[middleIndex] == value) {
				System.out.println("�ҵ��˸���"+ numbers[middleIndex]);
				isOk= true;
				break;
				//System.out.println(""+ numbers[middleIndex]);
			}
		}
		if(!isOk) {
			System.out.println("���������ڸ�������");
		}
		
	}
	

}
