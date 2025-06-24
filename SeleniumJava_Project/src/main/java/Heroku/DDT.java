//Package
package main.java.Heroku;

import org.testng.annotations.Test;

import main.java.utils.BaseClass;
import main.java.utils.DataManipulation;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT{	
	    XSSFWorkbook workBook;
	    XSSFSheet sheet;
	    String filepath = "resources/Heroku/DataSource.xlsx";
	    String username;
	    String pass;
	    int count;
		@Test
		public void readFile(){
			workBook = DataManipulation.getWorkbook(filepath);
			int rowcount = DataManipulation.getRowCount(workBook,0);
			while(count<rowcount) {
			username = DataManipulation.getData(workBook,0,count,0);
			pass = DataManipulation.getData(workBook,0,count,1);
			count++;
			System.out.println(username + " " + pass);
			}	
		}
		
}