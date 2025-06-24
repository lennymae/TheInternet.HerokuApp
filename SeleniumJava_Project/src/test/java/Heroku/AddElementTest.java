package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.AddElement;

public class AddElementTest {
	 
	 @Test
	    public void testAddElement() {
		    
	        AddElement addElement = new AddElement();
	        addElement.addElement();
	        addElement.deleteElement();
	    }
}
