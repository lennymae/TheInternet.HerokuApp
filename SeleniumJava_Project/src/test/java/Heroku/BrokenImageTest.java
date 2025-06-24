package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.BrokenImage;

public class BrokenImageTest {
	 
	 @Test
	    public void testBrokenImage() {
	        BrokenImage brokenImage  = new BrokenImage();
	        brokenImage.validateFirstImageIsBroken();
	        brokenImage.validateThirdImageIsPlaceholder();
	    
	    }
}
