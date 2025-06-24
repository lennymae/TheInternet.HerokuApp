package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.DDT;

public class DDTTest {
	 
	 @Test
	    public void testDDT() {
	        DDT ddt = new DDT();
	        ddt.readFile();
	    }
}
