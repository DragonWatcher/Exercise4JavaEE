package XML学习;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 解析自定义xml文件
 * @author mht
 * @date 2018年12月4日下午3:22:26
 */
public class XMLParser {
	
	@Test
	public void parseXML() throws UnsupportedEncodingException {
		
		try {
			SAXReader saxRdr = new SAXReader();
			Document xmlDom = saxRdr.read(new File(this.getClass().getResource("").toString().getBytes("UTF-8").toString() + "/demo.xml"));
			Element rootEle = xmlDom.getRootElement();
			
			System.out.println(rootEle.toString());
			System.out.println(rootEle.getName());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}

}
