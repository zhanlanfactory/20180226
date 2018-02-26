package dom;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {
	public static void main(String[] args) {
		// 创建DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 创建DocumentBuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 加载book.xml到当前项目下
			Document document = db.parse("book.xml");
			// 获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			// 遍历每一个book节点;
			// 获取节点个数
			int length = bookList.getLength();
			System.out.println("一共有" + length + "本书");
			for (int i = 0; i < length; i++) {
			System.out.println("===========================");
				// NodeList索引值从0开始;
				Node book = bookList.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				// 遍历book的属性;
				System.out.println("第" + (i + 1) + "本书;共有" + attrs.getLength() + "个属性");
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名:" + attr.getNodeName());
					// 获取属性值
					System.out.println("--属性值:" + attr.getNodeValue());
				}

				/*
				// 如果知道节点中属性只有一个且知道名字,例如知道只有一属性名id,可以强制转换成element
				Element book = (Element) bookList.item(i);
				// 属性值为
				String attrValue = book.getAttribute("id");
				*/
				
				
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "本书;共有" + childNodes.getLength() + "个子节点");
				for (int j = 0; j < childNodes.getLength(); j++) {
					/**
					 * 常用节点类型有三种,"Element","Attr","Text";
					 * 返回节点名分别为"element name","属性名称","#Text"
					 * 返回节点值分别为"null","属性值","节点内容"
					 */
					//区分text类型和element类型node
					if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE) {
						//获取了element类型节点的节点名
						System.out.print("第"+(j+1)+"个节点名"+childNodes.item(j).getNodeName()+"--");
						//获取element类型节点的节点值(获取节点下第一个子节点的节点值)
						//System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
						//第二种方法获取节点值(getTextContent会获取节点下所有节点值)
						System.out.println(childNodes.item(j).getFirstChild().getTextContent());
					}
				}

			}
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
