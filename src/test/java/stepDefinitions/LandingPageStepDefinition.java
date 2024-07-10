package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TextContextSetUp;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	TextContextSetUp testContextSetUp;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TextContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
		this.landingPage=testContextSetUp.pageObjectManager.getLandingPage();
	}
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//testContextSetUp.testBase.WebDriverManager();
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
		
	}
	@When("^User Searched with shortname (.+) and extracted the actual name of product$")
	public void user_searched_with_shortname_and_extracted_the_actual_name_of_product(String shortName) throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		//LandingPage landingPage=new LandingPage(testContext.driver);
		
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	    testContextSetUp.landingPageProductName= landingPage.getProductName().split("-")[0].trim();
	    		//testContext.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	    System.out.println(testContextSetUp.landingPageProductName+" is extracted from Homepage");
	}
	
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity) {
		landingPage.incementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
	
	 
	
	
}
