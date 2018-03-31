package com.wujianbo.five;

import java.io.File;
import java.security.cert.TrustAnchor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Demo09 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Demo09 demo09= new Demo09();
		demo09.createXmlByDom();

	}
	
	private void createXmlByDom() throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		String xmlName= System.getProperty("user.dir") + "\\data\\NewStudents.xml";
		//System.out.println(xmlName);
		
		DocumentBuilder db= dbf.newDocumentBuilder();
		//System.out.println(db);
		Document doc= db.parse(xmlName);
//		Element root= doc.getDocumentElement();
		
//		Element son= doc.createElement("son");
//		son.setAttribute("id", "001");
//		Element name= doc.createElement("name");
//		name.setTextContent("Жљзг");
//		son.appendChild(name);
//		Element age= doc.createElement("age");
//		age.setTextContent("10");
//		son.appendChild(age);
//		
//		root.appendChild(son);
//		
//		TransformerFactory factory= TransformerFactory.newInstance();
//		Transformer former= factory.newTransformer();
//		former.transform(new DOMSource(doc), new StreamResult(new File(xmlName)));
		
		

	}

}
