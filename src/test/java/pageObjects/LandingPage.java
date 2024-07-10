package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	By search=By.xpath("//input[@type='search']");
	By productName=By.xpath("//h4[@class='product-name']");
	By topDeals=By.xpath("//a[text()='Top Deals']");
	By incementSymbol=By.xpath("//a[@class='increment']");
	By addToCart=By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();  
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public void incementQuantity(int quantity) {
		
		int i=quantity-1;
		while(i>0) {
			driver.findElement(incementSymbol).click();
			i--;
		}
		driver.findElement(incementSymbol).click();
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
	
public String getTitleLandingPage() {
	return driver.getTitle();
}
	
	
}
