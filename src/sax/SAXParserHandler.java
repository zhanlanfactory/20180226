package sax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	/**
	 * 用于遍历xml文件的"开始"标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// qName代表走到某个元素的名字
		// 调用父类startE;ement方法
		super.startElement(uri, localName, qName, attributes);
		// 开始解析book元素的属性
		if (qName.equals("book")) {
			/*
			 * // 1、已知book元素下的属性名称,根据属性名称获取属性值 String value =
			 * attributes.getValue("id"); System.out.println("book的属性值是:" +
			 * value);
			 */
			// 2、不知道book元素的名称以及个数,如何获取属性名以及属性值
			int num = attributes.getLength();
			for (int i = 0; i < num; i++) {
				System.out.print("book元素的第" + (i + 1) + "个属性名是" + attributes.getQName(i));
				System.out.println("--属性值是:" + attributes.getValue(i));
			}
		} else if (!qName.equals("book") && !qName.equals("bookstore")) {
			System.out.print("节点名是:" + qName);
		}

	}

	// 获取节点中所有内容,走到每个节点时候都会被调用
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if (!"".equals(value.trim())) {
			System.out.println("--节点值:" + value);

		}
	}

	/**
	 * 用于遍历xml文件的"结束"标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		// 判断是否针对一本书已经遍历结束
		if (qName.equals("book")) {
			System.out.println("================结束遍历================");
		}

	}

	/**
	 * 用来标识解析"开始"
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX解析开始");
	}

	/**
	 * 用来标识解析"结束"
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}
}
