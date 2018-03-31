package com.wujianbo.compare;

public class ArrayHandle {
	
	// �����������������ð������
	public Integer[] arraySort(Integer[] array) {
		Integer i, j, temp, sorted;

		for(i=0; i<array.length-1; i++)
		{
			sorted = 0;
			for(j=0; j<array.length-i-1; j++)
			{
				if(array[j] > array[j+1])
				{
					sorted = 1;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			if (sorted == 0) break;
		}
		
		return array;
	}
	
	// ������������бȽ�
	public boolean arrayCompare(Integer[] a, Integer[] b) {
		int i;
		boolean flag = true;
		for (i=0; i<a.length; i++)
		{
			if (a[i] != b[i])
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
}