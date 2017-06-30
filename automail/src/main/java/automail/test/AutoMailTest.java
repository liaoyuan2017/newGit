package automail.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import automail.entity.SheetDetail;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AutoMailTest {
	int i;
	Sheet sheet;
	Workbook book;
	Cell cell1;
	List<SheetDetail> list = new ArrayList<SheetDetail>();
	List<String> strlist = new ArrayList<String>();
	
	@Test
	public void readXMl(){
		/*固定格式*/			
		i = 0;
		while(true){
			cell1 = sheet.getCell(0,i);
			if("".equals(cell1.getContents()) == true){
				break;
			}
			String b = sheet.getCell(0,i).getContents()+";"+sheet.getCell(1,i).getContents()+";"+sheet.getCell(2,i).getContents()
					+";"+sheet.getCell(3,i).getContents()+";"+sheet.getCell(4,i).getContents()+";"+sheet.getCell(5,i).getContents()
					+";"+sheet.getCell(6,i).getContents()+";"+sheet.getCell(7,i).getContents()+";"+sheet.getCell(8,i).getContents()
					+";"+sheet.getCell(9,i).getContents()+";"+sheet.getCell(10,i).getContents()+";"+sheet.getCell(11,i).getContents()
					+";"+sheet.getCell(12,i).getContents()+";"+sheet.getCell(13,i).getContents()+";"+sheet.getCell(14,i).getContents()
					+";"+sheet.getCell(15,i).getContents()+";"+sheet.getCell(16,i).getContents()+";"+sheet.getCell(17,i).getContents()
					+";"+sheet.getCell(18,i).getContents()+";"+sheet.getCell(19,i).getContents()+";"+sheet.getCell(20,i).getContents()
					+";"+sheet.getCell(21,i).getContents()+";"+sheet.getCell(22,i).getContents()+";"+sheet.getCell(23,i).getContents()
					+";"+sheet.getCell(24,i).getContents()+";"+sheet.getCell(25,i).getContents()+";"+sheet.getCell(26,i).getContents()
					+";"+sheet.getCell(27,i).getContents()+";"+sheet.getCell(28,i).getContents()+";"+sheet.getCell(29,i).getContents()
					+";"+sheet.getCell(30,i).getContents()+";"+sheet.getCell(31,i).getContents()+";"+sheet.getCell(32,i).getContents()
					+";"+sheet.getCell(33,i).getContents();
			b.replaceAll("'\"", "");
			strlist.add(b);
			i++;
	   }
	}
	
	public void readXML2(){
		/*固定格式实体类*/
		i = 0;
		while(true){
			cell1 = sheet.getCell(0,i);
			if("".equals(cell1.getContents()) == true){
				break;
			}
			SheetDetail emp = new SheetDetail();
			emp.setEmpid(sheet.getCell(0,i).getContents());
			emp.setEmpname(sheet.getCell(1,i).getContents());
			emp.setEmail(sheet.getCell(2,i).getContents());
			emp.setArea(sheet.getCell(3,i).getContents());
			emp.setDepart(sheet.getCell(4,i).getContents());
			emp.setCity(sheet.getCell(5,i).getContents());
			emp.setIdtype(sheet.getCell(6,i).getContents());
			emp.setId(sheet.getCell(7,i).getContents());
			emp.setState(sheet.getCell(8,i).getContents());
			emp.setDays1(sheet.getCell(9,i).getContents());
			emp.setDays2(sheet.getCell(10,i).getContents());
			emp.setHolidayH(sheet.getCell(11,i).getContents());
			emp.setLeaveday(sheet.getCell(12,i).getContents());
			emp.setSickday(sheet.getCell(13,i).getContents());
			emp.setLateday(sheet.getCell(14,i).getContents());
			emp.setBasepay(sheet.getCell(15,i).getContents());
			emp.setBaesup(sheet.getCell(16,i).getContents());
			emp.setAward(sheet.getCell(17,i).getContents());
			emp.setCompup(sheet.getCell(18,i).getContents());
			emp.setOutup(sheet.getCell(19,i).getContents());
			emp.setWorkup(sheet.getCell(20,i).getContents());
			emp.setLeavecut(sheet.getCell(21,i).getContents());
			emp.setSickcut(sheet.getCell(22,i).getContents());
			emp.setLatecut(sheet.getCell(23,i).getContents());
			emp.setOther(sheet.getCell(24,i).getContents());
			emp.setPay(sheet.getCell(25,i).getContents());
			emp.setIns1(sheet.getCell(26,i).getContents());
			emp.setIns2(sheet.getCell(27,i).getContents());
			emp.setIns3(sheet.getCell(28,i).getContents());
			emp.setIns4(sheet.getCell(29,i).getContents());
			emp.setIns5(sheet.getCell(30,i).getContents());
			emp.setTax(sheet.getCell(31,i).getContents());
			emp.setOthercut(sheet.getCell(32,i).getContents());
			emp.setRealpay(sheet.getCell(33,i).getContents());
			list.add(emp);
			i++;
	    }
	}
	
}
