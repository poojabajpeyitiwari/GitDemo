package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GenericUtils {

	public WebDriver driver;
	public Actions action;
	public WebElement element;
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	public void switchWindowToChild() {
		Set<String> windows=driver.getWindowHandles();
		  Iterator<String> it=windows.iterator();
		  String parentId=it.next();
		  String childId=it.next();
		  driver.switchTo().window(childId);
	}
	
	public void moveToElement(WebElement element) {
		action=new Actions(driver);
		action.moveToElement(element).click().build().perform();;
	}
}
