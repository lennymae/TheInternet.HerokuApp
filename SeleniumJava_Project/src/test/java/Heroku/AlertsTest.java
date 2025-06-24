package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.Alerts;

public class AlertsTest {
	 
	 @Test
	    public void testAlerts() {
	        Alerts alerts = new Alerts();
	        alerts.clickJSAlertPrompt();
	        alerts.clickJSConfirmPrompt();
	        alerts.clickJSPrompt();
	    }
}
