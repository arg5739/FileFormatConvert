package com.in.webservices;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathExpression;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class CheckingAllowFomatAbstact {
	XPathExpression validOptions = null;
	HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

	CheckingAllowFomatAbstact() {
		generateListOfPossibleFormat();

	}

	void generateListOfPossibleFormat() {

		try {
			URL url = getClass().getResource("list.xml");
			File fXmlFile = new File(url.toURI());
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dcoumentBuilder = factory.newDocumentBuilder();
			Document doc = dcoumentBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			NodeList outerNodenList = doc.getElementsByTagName("from");

			for (int temp = 0; temp < outerNodenList.getLength(); temp++) {

				Node nNode = outerNodenList.item(temp);
				Element eElement = (Element) nNode;

				NodeList insideList = eElement.getElementsByTagName("to");

				HashSet<String> insideSet = new HashSet<String>();

				for (int j = 0; j < insideList.getLength(); j++) {
					Node nNode1 = insideList.item(j);
					Element eElement2 = (Element) nNode1;
					insideSet.add(eElement2.getTextContent());
				}
				map.put(eElement.getAttribute("id"), insideSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	boolean validCheck(String input, String output) {

		if (map.containsKey(input)) {
			HashSet<String> toValue = map.get(input);
			if (toValue.contains(output)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
