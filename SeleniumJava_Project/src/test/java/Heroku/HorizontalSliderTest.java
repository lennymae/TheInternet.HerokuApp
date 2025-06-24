package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.HorizontalSlider;

public class HorizontalSliderTest {
	 
	 @Test
	    public void testHorizontalSlider() {
		 HorizontalSlider hs = new HorizontalSlider();
		 	hs.dragAndDropSlider();
	    }
}
