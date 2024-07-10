package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	public WebDriver driver;
	
public CheckOutPage(WebDriver driver) {
	this.driver=driver;
}

By addToCartButton=By.xpath("//button[text()='ADD TO CART']");
By cart=By.xpath("//img[@alt='Cart']");
By proceedToCheckout=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
By productName=By.xpath("//p[@class='product-name']");
By promoButton=By.xpath("//button[@class='promoBtn']");
By placeOrderButton=By.xpath("//button[text()='Place Order']");

public void addToCart() {
	driver.findElement(addToCartButton).click();
}
public void cart() {
	driver.findElement(cart).click();;
}

public void proceedToCheckout() {
	driver.findElement(proceedToCheckout).click();
}

public String getProductName(){
	return driver.findElement(productName).getText();
	
}

public boolean verifyPromoButton() {
	return driver.findElement(promoButton).isDisplayed();

}
public boolean verifyPlaceOrderButton() {
	return driver.findElement(placeOrderButton).isDisplayed();

}
}
