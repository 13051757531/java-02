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
	
	//读取文档内容
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
	
	//新建xml,并写入内容
	private void createXml() throws Exception {
		// TODO Auto-generated method stub
		Element root= DocumentHelper.createElement("Person");
		Document doc= DocumentHelper.createDocument(root);
		
		root.addAttribute("学校", "南大").addAttribute("位置", "江西");
		
		Element element1= root.addElement("学生");
		element1.addElement("姓名").addAttribute("婚姻", "单身").addText("小章");
		element1.addElement("年龄").addText("21");
		
		Element element2= root.addElement("学生");
		element2.addElement("姓名").addAttribute("婚姻", "单身").addText("小红").addElement("爱好").addText("唱歌");
		element2.addElement("年龄").addText("22");
		
		OutputFormat format= new OutputFormat(" ", true);
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter= new XMLWriter(new FileOutputStream(fileName2), format);
		xmlWriter.write(doc);
		xmlWriter.close();
	}
	
	//修改xml文件
	private void modifyXml() throws Exception {
		// TODO Auto-generated method stub
		String name= "何国学";
		String key= "degree";
		String value= "研究生";
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
	
	//删除后修改指定节点
	private void deleteXml() throws Exception {
		// TODO Auto-generated method stub
		SAXReader sr= new SAXReader();
		Document doc= sr.read(new File(fileName2));
		System.out.println(doc);

	}
	

}
