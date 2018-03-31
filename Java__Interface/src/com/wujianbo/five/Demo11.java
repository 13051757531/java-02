package com.wujianbo.five;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Generated;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo11 {
	String fileName= System.getProperty("user.dir") + "\\data\\Students.xml";
	String fileName2= System.getProperty("user.dir") + "\\data\\Person.xml";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo11 demo11= new Demo11();
		//System.out.println(demo11.fileName);
		//System.out.println(demo11.fileName2);
		//demo11.readXml();
		//demo11.createXml();
		demo11.deleteXml();

	}
	
	//��ȡ�ĵ�����
	private void readXml() throws Exception {
		// TODO Auto-generated method stub
		SAXReader sr= new SAXReader();
		org.dom4j.Document doc= sr.read(new File(fileName));
		//System.out.println(doc);
		List nameList= doc.selectNodes("/class/student/name");
		List ageList= doc.selectNodes("/class/student/age");
		List sexList= doc.selectNodes("/class/student/sex");
		//System.out.println(nameList);
		for(int i=0; i<nameList.size(); i++) {
			String name= ((Element)nameList.get(i)).getTextTrim();
			System.out.print("name=" + name);
			String age= ((Element)ageList.get(i)).getTextTrim();
			System.out.print("age=" + age);
			String sex= ((Element)sexList.get(i)).getTextTrim();
			System.out.println("sex=" + sex);
			System.out.println("==================");
		}
		
	}
	
	//�½�xml,��д������
	private void createXml() throws Exception {
		// TODO Auto-generated method stub
		Element root= DocumentHelper.createElement("Person");
		Document doc= DocumentHelper.createDocument(root);
		
		root.addAttribute("ѧУ", "�ϴ�").addAttribute("λ��", "����");
		
		Element element1= root.addElement("ѧ��");
		element1.addElement("����").addAttribute("����", "����").addText("С��");
		element1.addElement("����").addText("21");
		
		Element element2= root.addElement("ѧ��");
		element2.addElement("����").addAttribute("����", "����").addText("С��").addElement("����").addText("����");
		element2.addElement("����").addText("22");
		
		OutputFormat format= new OutputFormat(" ", true);
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter= new XMLWriter(new FileOutputStream(fileName2), format);
		xmlWriter.write(doc);
		xmlWriter.close();
	}
	
	//�޸�xml�ļ�
	private void modifyXml() throws Exception {
		// TODO Auto-generated method stub
		String name= "�ι�ѧ";
		String key= "degree";
		String value= "�о���";
		SAXReader sr= new SAXReader();
		org.dom4j.Document doc= sr.read(new File(fileName));
		List namelist= doc.selectNodes("/class/students/name");
		java.util.Iterator iterator= namelist.iterator();
		
		while(iterator.hasNext()) {
			Element element= (Element)iterator.next();
			if(name!=null && name.equals(element.getText())) {
				Element pe= element.getParent();
				List childList= pe.elements();
				for(int i=0; i<childList.size(); i++) {
					String nodeName= ((Element)childList.get(i)).getName();
					if(key!=null && key.equals(nodeName) ) {
						((Element)childList.get(i)).setText(value);
					}
				}
				
			}
		}
		
		OutputFormat format= new OutputFormat(" ", true);
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter= new XMLWriter(new FileOutputStream(fileName), format);
		xmlWriter.write(doc);
		xmlWriter.close();
	}
	
	//ɾ�����޸�ָ���ڵ�
	private void deleteXml() throws Exception {
		// TODO Auto-generated method stub
		SAXReader sr= new SAXReader();
		Document doc= sr.read(new File(fileName2));
		System.out.println(doc);

	}
	

}
