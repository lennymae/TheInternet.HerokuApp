package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.FormAuthentication;

public class FormAuthenticationTest {
	 
	 @Test
	    public void testFormAuthentication() {
		 	FormAuthentication formAuth = new FormAuthentication();
		 	formAuth.loginCorrectCredentials();
		 	formAuth.loginIncorrectPassword();
	    }
}
