package automail.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.print.DocFlavor.URL;

public class PropertiesTest {
	 public static void main(String[] args){  
	        PropertiesTest pt = new PropertiesTest();  
	        try {  
	            pt.getProperties();  
	            java.net.URL url = PropertiesTest.class.getClassLoader().getResource("detail.xml");
	            System.out.println(url.getFile());
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	    }  
	
	
    private void getProperties() throws IOException {  
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");  
        System.out.println("begin!!!");  
        Properties properties = new Properties();  
        try{  
            properties.load(inputStream);  
        }catch (IOException ioE){  
            ioE.printStackTrace();  
        }finally{  
            inputStream.close();  
        }  
        System.out.println("name:"+properties.getProperty("smtp.hostname"));  
    }
}
