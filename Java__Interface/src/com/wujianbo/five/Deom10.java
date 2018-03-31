package com.wujianbo.five;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Deom10 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Deom10 deom10= new Deom10();
		deom10.modifyXmlByDom();

	}
	
	private void modifyXmlByDom() throws Exception {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		String xmlName= System.getProperty("user.dir") + "\\data\\Students.xml";
		
		DocumentBuilder db= dbf.newDocumentBuilder();
		Document doc= db.parse(xmlName);
		//System.out.println(doc);
		Element root= doc.getDocumentElement();
		//System.out.println(root);    
		
		XPathFactory xpFactory= XPathFactory.newInstance();
		XPath xpath= xpFactory.newXPath();
		Element node= (Element)xpath.evaluate("/cl4ass/student[@sequence='2']", root, XPathConstants.NODE);
		node.getElementsByTagName("degree").item(0).setTextContent("ÑÐ¾¿Éú");
		
		TransformerFactory factory= TransformerFactory.newInstance();
		Transformer former= factory.newTransformer();
		former.transform(new DOMSource(doc), new StreamResult(new File(xmlName)));
		
		
	}

}
