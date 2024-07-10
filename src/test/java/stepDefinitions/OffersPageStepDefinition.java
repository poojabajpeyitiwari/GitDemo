package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetUp;

public class OffersPageStepDefinition {
	
	public String offerPageProductName;
	TextContextSetUp textContextSetup;
	public PageObjectManager pageObjectManager;
	
	public OffersPageStepDefinition(TextContextSetUp textContextSetup) {
		this.textContextSetup=textContextSetup;
	}
	
	@Then("^User Searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	  switchToOfferesPage();
	  //OffersPage offersPage=new OffersPage(textContextSetup.driver);
	  OffersPage offersPage=textContextSetup.pageObjectManager.getOffersPage();
	  offersPage.searchItem(shortName);
	  //textContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Tom");
	  Thread.sleep(2000);
	  //offerPageProductName= textContextSetup.driver.findElement(By.xpath("//tr/td[1]")).getText();
	  offerPageProductName=offersPage.getProductName();
	  System.out.println(offerPageProductName+" is extracted from offers Page");
	  
	}
	
	public void switchToOfferesPage() {
		//pageObjectManager= new PageObjectManager(textContextSetup.driver);
		LandingPage landingPage=textContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		textContextSetup.genericUtils.switchWindowToChild();
		
	
		
		//textContextSetup.driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		/*
		 * Set<String> windows=textContextSetup.driver.getWindowHandles();
		 * Iterator<String> it=windows.iterator(); String parentId=it.next(); String
		 * childId=it.next(); textContextSetup.driver.switchTo().window(childId);
		 */
		 
	}
	
	@And("Validate product name in offers page matches with Landing Page")
	public void Validate_product_name_matches_with_Landing_Page() {
	Assert.assertEquals(textContextSetup.landingPageProductName, offerPageProductName);	
	}
}
