package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static List<String> readExcel(String path,String Sheet,int r, int column) throws IOException {
		FileInputStream file=new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(Sheet);
		String s;
		List<String> getdata=new ArrayList<String>();
		for(int i=0;i<r;i++) {
			XSSFRow row=sheet.getRow(i);
			XSSFCell cell=row.getCell(column);
			try
			{
				
				
				DataFormatter formatter = new DataFormatter();
	            s = formatter.formatCellValue(cell);
	            
			}
			catch (Exception e)
			{
				s="";
			}
			getdata.add(s);
		}
		return getdata;
		
		
	}
	
	
	public static void setData(String path,String sheet,int r,int c,String[] data) throws IOException {
			
			FileInputStream fi = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet ws = wb.getSheet(sheet);
			XSSFRow row = ws.createRow(r);
			for(int i=0;i<c;i++) {
				
				XSSFCell cell = row.createCell(i);
				cell.setCellValue(data[i]);
			}
			FileOutputStream fo = new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fo.close();
			fi.close();
			
		}
	
	
	
	
}





