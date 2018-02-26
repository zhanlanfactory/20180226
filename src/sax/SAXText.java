package sax;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXText {
	public static void main(String[] args) {
		// 获取SAXParserFactory实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 通过factory获取SAXParser实例
		try {
			SAXParser parser = factory.newSAXParser();
			// 创建handler对象
			SAXParserHandler handler = new SAXParserHandler();
			parser.parse("book.xml", handler);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
