package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Demo;
import pageObjects.Doctors;
import pageObjects.surgeries;
import testBase.Base;

public class listsurgeries extends Base{
	public surgeries sg;
	
	@Test(groups= {"regression"},dependsOnMethods = { "test_title_surgeries" })
	public void test() throws IOException {
		
		
		
		sg.listofsurgeries(sg.surgerieslist);
		logger.info("All the list of surgeries have been captured");	
		scrollDown(sg.getElement());
		captureScreen("surgeries");
		
	}
	@Test(groups= {"sanity"})
	public void test_title_surgeries() throws IOException {
		sg=new surgeries(driver);
		sg.click_surgeries();
		String st=driver.getTitle();
		Assert.assertEquals(st,getProperties().getProperty("surgeriestitle"));
		captureScreen("surgeries");
	
		
	}

}
