package com.wujianbo.five;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.demo.Demo;
import jxl.read.biff.BiffException;

public class Demo05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo05 demo05= new Demo05();
		demo05.readExcelByJxl();

	}
	
	public void readExcelByJxl() {
		String path= System.getProperty("user.dir");
		path= path + "\\data\\Students.xls";
		//System.out.println(path);
		try {
			File file= new File(path);
			FileInputStream fis= new FileInputStream(file);
			jxl.Workbook rwb= Workbook.getWorkbook(fis);
			
			Sheet[] sheet= rwb.getSheets();
			for(int i=0; i<sheet.length; i++) {
				Sheet rs= rwb.getSheet(i);
				for(int j=0; j<rs.getRows(); j++) {
					Cell[] cells= rs.getRow(j);
					for(int k=0;k<cells.length; k++) {
						System.out.print(cells[k].getContents());
						System.out.print("\t");
						
					}
					System.out.println();
					
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



































