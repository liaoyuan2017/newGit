package automail;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ReaderXML {
	public String read(String path,String[] key,String[] value){
		String str = null;
		str = reader(path,key,value);
		return str;
		
	}
	
	private String reader(String path,String[] key,String[] value){
		SAXReader reader =  new SAXReader();
		String str = null;
		try {
			Document d = reader.read(new File(path));
			Element e = d.getRootElement();
			write(d,e,key,value);
			Element htmle  = e.element("html");//取出html
			str=htmle.asXML();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	private static void write(Document d,Element root,String[] key,String[] value){
		List<Node> namenode = d.selectNodes("/xml-body/html/body/table/thead/tr");
		Element nametr = (Element) namenode.get(0);
		nametr.addAttribute("height", "60");
		for(int i=0;i<key.length;i++){
			Element tds = nametr.addElement("th");
			tds.addText(key[i]);
		}
		
		List<Node> valuenode = d.selectNodes("/xml-body/html/body/table/tbody/tr");
		Element valuetr = (Element) valuenode.get(0);
		valuetr.addAttribute("height", "120");
		for(int i=0;i<value.length;i++){
			Element tds = valuetr.addElement("td");
			tds.addText(value[i]);
		}
		
//		List<Node> valuenode = d.selectNodes("/xml-body/html/body/table/thead/tr/th");
//		Iterator val=valuenode.iterator();
//		while(val.hasNext()){
//			Element element = (Element)val.next();
//			System.out.println(element.getText());
//		}
		
//		List<Node> valuenode = d.selectNodes("/xml-body/html/body/table/tbody/tr/td");
//		Iterator val=valuenode.iterator();
//		while(val.hasNext()){
//			Element element = (Element)val.next();
//			System.out.println(element.getText());
//		}
		
	}
	
	
}
