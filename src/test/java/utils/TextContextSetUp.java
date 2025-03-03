package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TextContextSetUp {
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TextContextSetUp() throws IOException {
		testBase=new TestBase();
		 pageObjectManager=new PageObjectManager(testBase.WebDriverManager());
		 genericUtils=new GenericUtils(testBase.WebDriverManager());
	}
}
