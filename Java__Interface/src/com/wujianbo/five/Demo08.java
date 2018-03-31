package com.wujianbo.five;

import javax.sound.midi.Sequence;
import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo08 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo08 demo08= new Demo08();
		demo08.readXmlByDom();

	}
	
	private void readXmlByDom() throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= factory.newDocumentBuilder();
		
		String xmlName= System.getProperty("user.dir") + "\\data\\Students.xml";
		//System.out.println(xmlName);
		Document doc= builder.parse(xmlName);
		doc.normalize();
		NodeList students= doc.getElementsByTagName("student");
		//Element s1= (Element)students.item(0);
		org.w3c.dom.Element s1= (org.w3c.dom.Element)students.item(0);
		System.out.println(s1.getAttribute("sequence"));
		
		Node id1= s1.getElementsByTagName("id").item(0);
		System.out.println(id1.getFirstChild().getNodeValue());
		System.out.println("===========================================");
		for(int i=0;i<students.getLength(); i++) {
			org.w3c.dom.Element son= (org.w3c.dom.Element)students.item(i);
			for(Node node= son.getFirstChild(); node!=null; node= node.getNextSibling()) {
				if(node.getNodeType() == node.ELEMENT_NODE) {
					String name= node.getNodeName();
					String value= node.getFirstChild().getNodeValue();
					System.out.print(name + ": " +value);
				}
			}
			System.out.println();
		}
		System.out.println("==========================================");
		
		
		
	}

}















