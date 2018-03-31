package com.wujianbo.five;

import java.awt.HeadlessException;
import java.awt.Label;
import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Demo07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo07 demo07= new Demo07();
		demo07.modifyExcelByJxl();
	}
	
	private void modifyExcelByJxl() {
		// TODO Auto-generated method stub
		String fileName= System.getProperty("user.dir") + "\\data\\Students.xls";
		try {
			Workbook wb= Workbook.getWorkbook(new File(fileName));
			WritableWorkbook book= Workbook.createWorkbook(new File(fileName), wb);
			WritableSheet sheet= book.getSheet(0);
			sheet.addCell(new jxl.write.Label(5, 3, "研究生"));
			//sheet.addCell(new Label(5, 3, "研究生"));
			
			book.write();
			book.close();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
