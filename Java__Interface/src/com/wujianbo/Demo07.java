package com.wujianbo;


	/*
	 * 3λ������λ����3�η����Ϊ��ԭֵ����Ϊˮ�ɻ���
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
			//����Ϊ234
			//��λ
			a= i%10;
			//ʮλ
			b= i/10%10;
			//��λ
			c= i/100;
			//ˮ�ɻ����жϲ����
			if (i == a*a*a + b*b*b + c*c*c) {
				System.out.println("ˮ�ɻ����У�"+i);
			}
			
		}
		
	}
	
	public void flowerTwo() {
		//��λ��ʮλ����λ���ҵ��ٽ��м��㸴�Ϲ�������
		/*
		 * ��λ��1~9
		 * ʮλ��0~9
		 * ��λ��0����9
		 */
		for (int i=1; i<=9; i++) {
			for (int j=0; j<=9; j++) {
				for (int k=0; k<=9; k++) {
					//System.out.println(i + " " + j + " " + k +" ");
					if ((i*100+j*10+k) == (i*i*i+j*j*j+k*k*k)) {
						System.out.println("ˮ�ɻ����ǣ�"+(i*100+j*10+k));
					}
				}
				
			}
			
		}
	}

}
