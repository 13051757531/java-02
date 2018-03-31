package com.wujianbo;


	/*
	 * 3位数，各位数的3次方相加为其原值，称为水仙花数
	 */
public class Demo07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo07 demo07= new Demo07();
		//demo07.flowerOne();
		demo07.flowerTwo();

	}
	
	public void flowerOne() {
		for (int i=100; i<=999; i++) {
			int a= 0;
			int b= 0;
			int c= 0;
			//System.out.println(i);
			//该数为234
			//个位
			a= i%10;
			//十位
			b= i/10%10;
			//百位
			c= i/100;
			//水仙花数判断并输出
			if (i == a*a*a + b*b*b + c*c*c) {
				System.out.println("水仙花数有："+i);
			}
			
		}
		
	}
	
	public void flowerTwo() {
		//百位、十位、个位数找到再进行计算复合规则的输出
		/*
		 * 百位：1~9
		 * 十位：0~9
		 * 个位：0——9
		 */
		for (int i=1; i<=9; i++) {
			for (int j=0; j<=9; j++) {
				for (int k=0; k<=9; k++) {
					//System.out.println(i + " " + j + " " + k +" ");
					if ((i*100+j*10+k) == (i*i*i+j*j*j+k*k*k)) {
						System.out.println("水仙花数是："+(i*100+j*10+k));
					}
				}
				
			}
			
		}
	}

}
