//Package
package TestScripts;

import org.testng.annotations.Test;

import Base.BaseClass;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT extends BaseClass{	
	    XSSFWorkbook workBook;
	    XSSFSheet sheet;
	    String filepath = "C:\\code\\DDT_CredentialSample.xlsx";
	    String username;
	    String pass;
	    int count;
		@Test
		public void readFile(){
			workBook = getWorkbook(filepath);
			int rowcount = getRowCount(workBook,0);
			while(count<rowcount) {
			username = getData(workBook,0,count,0);
			pass = getData(workBook,0,count,1);
			count++;
			System.out.println(username + " " + pass);
			}	
		}
		
}