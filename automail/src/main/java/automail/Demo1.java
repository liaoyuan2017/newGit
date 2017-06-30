package automail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import automailUtil.PropertiesUtil;


public class Demo1 {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();//可以加载一个配置文件
		 // 使用smtp：简单邮件传输协议 
		props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.transport.protocol", "smtp"); // 指定协议
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        
        
        Session session = Session.getInstance(props);//根据属性新建一个邮件会话  
        session.setDebug(true);
        
        Transport transport = session.getTransport();
        transport.connect(PropertiesUtil.SMTP_HOSTNAME, 25,PropertiesUtil.SMTP_USERNAME, PropertiesUtil.SMTP_PASSWORD);
        
        //读取exexl表数据
        List list = (new Read_excel()).readec();
        for(int i=1;i<list.size();i++){
        	Message msg  = new MimeMessage(session);
        	
        	String[] key = (String[]) list.get(0);
        	String[] value =(String[]) list.get(i);
        	
        	String email = value[2];
        	if(email.isEmpty()){
        		break;
        	}
            //设置信件内容
            msg.setSubject("每月工资邮件");
            msg.setSentDate(new Date());//msg.setText("邮件测试");
            //发送html内容
            String xml = new ReaderXML().read(PropertiesUtil.XML_PATH,key,value);
            msg.setContent(xml, "text/html;charset=gbk"); //发送HTML邮件，内容样式比较丰富 
            msg.setFrom(new InternetAddress(PropertiesUtil.SMTP_USERNAME));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            transport.sendMessage(msg, msg.getAllRecipients());
            //transport.sendMessage(msg, new Address[]{new InternetAddress(email)});
        }
        
        transport.close();
	}
	
	//添加附件
	private static void putFileToMail(Message msg) throws Exception{
		String filename ="/Users/chenpengfei/Documents/testSetting.xml";
		MimeMultipart content=new MimeMultipart();
		if(filename != null && filename.length()>0){
			MimeBodyPart part =new MimeBodyPart(); //创建MIME对象
			DataSource fs = new FileDataSource(filename); //创建文件流对象
			part.setDataHandler(new DataHandler(fs));
			part.setFileName(MimeUtility.encodeText(fs.getName()));
			content.addBodyPart(part); //添加二进制编码至邮件体中
		}
		 msg.setContent(content);//添加文本至邮件中
		 msg.saveChanges();     //保存修改
	}
	
	//群体发送
	public static void readAddressList(Message msg){
		String filename="/Users/chenpengfei/Documents/addr.xml";
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader bf = new BufferedReader(fr);
			int i = 0;
			String fileline;
			Address[] address = new Address[10];
			while((fileline = bf.readLine()) != null){
				if(i%10 != 0){
					address[i] = new InternetAddress(fileline);
				}else{
					address[i] = new InternetAddress(fileline);
				}
				i++;
				if(i%10 == 0){
					msg.addRecipients(Message.RecipientType.BCC, address);
				}
			}
			//新建地址数组，将余下的地址进行发送
			if(i>0){
				Address[] addr = new Address[i%10];
				for(int k=0;k<i%10;k++){
					addr[k] = address[k];
				}
				msg.addRecipients(Message.RecipientType.BCC, addr);
			}
			msg.saveChanges();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getmailContent(){
		
		return "<a>html 元素</a>：<b>邮件内容</b>";
	}
	

}
