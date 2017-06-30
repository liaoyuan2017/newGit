package automail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import automailUtil.PropertiesUtil;
import jxl.*;


public class Read_excel {
	int i;
	Sheet sheet;
	Workbook book;
	Cell cellc;
	Cell cellr;
	List list = new ArrayList();
	public List readec(){
		try {
			book = Workbook.getWorkbook(new File(PropertiesUtil.EXCEL_PATH));
			
			sheet = book.getSheet(0);
			int length=0;
			int height=0;
			length = getLength(length,cellc,sheet);//得到excel表列数
			height = getHeight(height,cellr,sheet);//得到excel表行数
			
			for(int i=0;i<height;i++){
				String[] str = new String[length];
				Cell cell = null;
				for(int j=0;j<length;j++){
					cell = sheet.getCell(j,i);
					str[j] = cell.getContents();
				}
				list.add(str);
			}
			
		book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public int getHeight(int height,Cell cellr,Sheet sheet){
		while(true){
			if(height < sheet.getRows()){
				cellr = sheet.getCell(0, height);
				if("".equals(cellr.getContents())){
					break;
				}
				height++;
			}else{
				break;
			}
		}
		return height;
	}
	
	public int getLength(int length,Cell cellc,Sheet sheet){
		while(true){
			if(length < sheet.getColumns()){
				cellc = sheet.getCell(length, 0);
				if("".equals(cellc.getContents())){
					break;
				}
				length++;
			}else{
				break;
			}
		}
		return length;
	}
	
}
