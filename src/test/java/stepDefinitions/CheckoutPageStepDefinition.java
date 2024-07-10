package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TextContextSetUp;

public class CheckoutPageStepDefinition {
	
	public WebDriver driver;
	public CheckOutPage checkOutPage;
	TextContextSetUp testContextSetUp;
	
	public CheckoutPageStepDefinition(TextContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		this.checkOutPage=testContextSetUp.pageObjectManager.getcheckOutPage();
		
	}
	
	@And("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkOutPage.verifyPromoButton());
		Assert.assertTrue(checkOutPage.verifyPlaceOrderButton());
		
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_and_validate_items_in_checkout_page(String name) throws InterruptedException {
		checkOutPage.cart();
		checkOutPage.proceedToCheckout();
		Thread.sleep(2000);
		String checkoutPageProductName=checkOutPage.getProductName().split("-")[0].trim();
		System.out.println(checkoutPageProductName);
	}
	

}
