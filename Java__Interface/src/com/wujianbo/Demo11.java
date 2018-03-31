package com.wujianbo;

public class Demo11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo11 demo11= new Demo11();
		demo11.bubSort();

	}
	
	//冒泡排序
	public void bubSort() {
		int[] number= {4, 3, 2, 9, 0, 33, 55, 78};
		//this.getMax(number, number.length);
		int temp= 0;
		int maxIndex= 0;
		//将最大数往后面靠，逐个减小
		for(int i=number.length; i>1; i--) {
			maxIndex= this.getMax(number, i);
			temp= number[i-1];
			number[i-1]= number[maxIndex];
			number[maxIndex]= temp;
		}
		for(int i=0; i<number.length; i++) {
			System.out.print(number[i] + " ");
		}	
	}
	//取一个数组中的最大值的下标
	public int getMax(int[] number, int a) {
		int maxIndex= 0;
		String abc= "jl";
		for(int i=0; i<a-1; i++) {
			if(number[i]<number[i+1]) {
				maxIndex= i+1;
			}
		}
		//System.out.println(maxIndex);
		return maxIndex;
	}

}
