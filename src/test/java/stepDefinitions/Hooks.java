package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetUp;

public class Hooks {
	TextContextSetUp textContextSetUp;
	public Hooks(TextContextSetUp textContextSetUp) {
		this.textContextSetUp=textContextSetUp;
	}
	
@After
public void afterScenario() throws IOException {
	textContextSetUp.testBase.WebDriverManager().quit();

}
@AfterStep
public void addScreenshot(Scenario scenario) throws IOException {
	WebDriver driver=textContextSetUp.testBase.WebDriverManager();
	if(scenario.isFailed())
	{
		//screenshot
		File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
	}
}
}
