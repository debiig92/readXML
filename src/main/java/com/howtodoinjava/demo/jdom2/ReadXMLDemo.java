package com.howtodoinjava.demo.jdom2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
 
@SuppressWarnings("unused")
public class ReadXMLDemo 
{   
    public static void main(String[] args) {

	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File("prueba.xml");

	  try {

		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("staff");

		for (int i = 0; i < list.size(); i++) {

		   Element node = (Element) list.get(i);

		   System.out.println("First Name : " + node.getChildText("firstname"));
		   System.out.println("Last Name : " + node.getChildText("lastname"));
		   System.out.println("Nick Name : " + node.getChildText("nickname"));
		   System.out.println("Salary : " + node.getChildText("salary"));

		}

	  } catch (JDOMException jdomex) {
		System.out.println(jdomex.getMessage());
	  } catch (IOException ex) {
            Logger.getLogger(ReadXMLDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
}