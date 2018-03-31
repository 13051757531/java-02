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
	
	//无序数组的查找
	public Boolean dicordNunberCheck(int[] numbers, int value) {
		//23，77,66,44,88
		//int value= 23;
		Boolean isOk= false;
		//int[] numbers= {23, 77, 66, 44, 88};
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == value) {
				isOk= true;
				break;
				//System.out.println("您找的数存在数组中");
			}else{
				isOk= false;
				//System.out.println("您找的数不存在");
			}
		}
		//System.out.println(isOk);
		return isOk;
	}
	
	//有序数组的查找
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
			//数在右边
			if(numbers[middleIndex] < value) {
				minIndex= middleIndex + 1;
				//System.out.println(minIndex);
				//数在左边
			}else if(numbers[middleIndex] > value) {
				maxIndex= middleIndex - 1;
			}
			else if(numbers[middleIndex] == value) {
				System.out.println("找到了该数"+ numbers[middleIndex]);
				isOk= true;
				break;
				//System.out.println(""+ numbers[middleIndex]);
			}
		}
		if(!isOk) {
			System.out.println("该数不存在该数组中");
		}
		
	}
	

}
