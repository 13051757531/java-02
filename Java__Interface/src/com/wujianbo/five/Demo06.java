package com.wujianbo.five;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Demo06 {
	public static void main(String[] args) {
		Demo06 demo06= new Demo06();
		demo06.writeExlByJxl();
	}
	
	private void writeExlByJxl() {
		// TODO Auto-generated method stub
		WritableWorkbook book= null;
		String[] info= {"���", "ѧ��", "����", "�Ա�", "����", "ѧ��", "ѧУ"};
		String fileName= System.getProperty("user.dir") + "\\data\\newStudents.xls";
		try {
			book= Workbook.createWorkbook(new File(fileName));
			WritableSheet sheet= book.createSheet("NewStudents.xls", 0);
			
			for(int i=0; i<7; i++) {//��ӱ�ͷ
				Label lable= new Label(i, 0, info[i]);
				sheet.addCell(lable);
			}
			
			sheet.addCell(new Label(0, 1, "1"));
			sheet.addCell(new Label(1, 1, "WNC115"));
			sheet.addCell(new Label(2, 1, "�⽨��"));
			sheet.addCell(new Label(3, 1, "��"));
			sheet.addCell(new Label(4, 1, "28"));
			sheet.addCell(new Label(5, 1, "����"));
			sheet.addCell(new Label(6, 1, "�Ĵ���ѧԺ"));
			
			book.write();
			book.close();
		} catch (RowsExceededException e) {
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











