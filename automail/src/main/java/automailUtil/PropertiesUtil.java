package automailUtil;

import java.io.InputStream;
import java.util.Properties;

import automail.Demo1;

public class PropertiesUtil {
	static Properties prop = new Properties();
	
	static{
		InputStream file = Demo1.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

	public static final String SMTP_HOSTNAME = prop.getProperty("smtp.hostname");
	public static final String SMTP_USERNAME = prop.getProperty("smtp.username");
	public static final String SMTP_PASSWORD = prop.getProperty("smtp.password");
	public static final String XML_PATH = prop.getProperty("xml.path");
	public static final String EXCEL_PATH = prop.getProperty("excel.path");
	
	
	
	
}
