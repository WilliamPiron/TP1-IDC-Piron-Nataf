import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XML {

	public Double parseXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		// Load the input XML document, parse it and return an instance of the
		// Document class.
		Document document = null;
		try {
			document = builder.parse("");
			document.getDocumentElement().normalize();

			System.out.print("Root element: ");
			System.out.println(document.getDocumentElement().getNodeName());

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<TauxFertilite> tauxFertilites = new ArrayList<>();

		System.out.println(document.getDocumentElement().getNodeName());
		NodeList nodeList = document.getElementsByTagName("record");
		System.out.println("----------------------------");



		// parcours du XML
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
//			System.out.println("\nCurrent Element :");
//			System.out.println(node.getNodeName());

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;

				NodeList fieldList = elem.getElementsByTagName("field");

				Boolean valid = false;

				// parcours de chaque record
				for (int countfield = 0; countfield < fieldList.getLength(); countfield++) {
					Node node1 = fieldList.item(countfield);

					if (node1.getNodeType() == node1.ELEMENT_NODE) {
						Element fieldNode = (Element) node1;

/*						System.out.print("field name : ");
						System.out.println(fieldNode.getAttribute("name"));

						System.out.print("field : ");
						System.out.println(fieldNode.getTextContent());
*/
						if (countfield == 0) {
							valid = checkCountry(fieldNode);
						} else if (countfield == 1 && valid) {
							valid = checkItem(fieldNode);
						} else if (countfield == 2 && valid) {
							valid = checkYear(fieldNode);
						}
						else if (countfield == 3 && valid) {
							String f = fieldNode.getTextContent();
							return Double.parseDouble(f);

						}

					}
				}
				}

		}

		System.out.println(tauxFertilites.toString());
		return 0.0;
	}

	private static boolean checkCountry(Element element) {
		return ("France".equals(element.getTextContent()));
	}
	private static boolean checkItem(Element element) {
		return ("Adolescent fertility rate (births per 1,000 women ages 15-19)".equals(element.getTextContent()));
	}
	private static boolean checkYear(Element element) {
		return ("2007".equals(element.getTextContent()));
	}
}


