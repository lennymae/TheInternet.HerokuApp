package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.InputValidation;

public class InputValidationTest {
	 
	 @Test
	    public void testInputValidation() {
		 InputValidation inputVal = new InputValidation();
		 inputVal.validateInputValueNumber();
	    }
}
