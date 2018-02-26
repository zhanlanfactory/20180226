package dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {
	public static void main(String[] args) {
		// 解析book.xml文件
		// 创建SAXReader的对象reader
		SAXReader reader = new SAXReader();
		// 通过reader对象的read方法加载books.xml文件,获取document对象.
		try {
			Document document = reader.read(new File("book.xml"));
			// 通过document对象获取根节点bookstore
			Element bookStore = document.getRootElement();
			// 通过element对象的elementIterator方法获取迭代器
			Iterator it = bookStore.elementIterator();
			// 遍历迭代器,获取根节点中的信息(书籍)
			while (it.hasNext()) {
				Element book = (Element) it.next();
				// 获取book的属性名以及属性值
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("节点名:" + attr.getName() + "--节点值:" + attr.getValue());
				}

				Iterator itt = book.elementIterator();
				while (itt.hasNext()) {
					Element bookChild = (Element) itt.next();
					System.out.println("节点名:" + bookChild.getName() + "--节点值:" + bookChild.getStringValue());
				}
				System.out.println("=============================");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
