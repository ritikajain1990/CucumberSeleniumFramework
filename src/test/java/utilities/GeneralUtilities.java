package utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GeneralUtilities {

	WebDriver driver;
	public GeneralUtilities(WebDriver driver) {
		this.driver=driver;
	}
	public void switchToWindow()
	{
		Set<String> whs = driver.getWindowHandles();
		Iterator<String> itr=whs.iterator();
		String parentWindow =itr.next();
		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
	}
	
}
