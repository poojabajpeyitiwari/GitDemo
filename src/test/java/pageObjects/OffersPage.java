package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    
	public WebDriver driver;
	By search=By.xpath("//input[@id='search-field']");
	By productName=By.xpath("//tr/td[1]");
	
	public OffersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
 
	public String getProductName() {
	return driver.findElement(productName).getText();
}
}
