package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Demo;
import pageObjects.HomePage;
import testBase.Base;
import utilities.ExcelUtility;


public class demo extends Base {
	public Demo dm;
	@Test(groups= {"regression"},dependsOnMethods = { "test_title_demo" })
	public void test() throws IOException {
		
		
		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 0));
		captureScreen("invaliddata");
		Assert.assertEquals(dm.status(), false);
		logger.info("Invalid details have been entered");	
		
		
		
	}
	@Test(groups= {"sanity"})
	public void test_title_demo() throws IOException {
		dm=new Demo(driver);
		dm.click_corporates();
		dm.click_wellnessplan();
		String dt=driver.getTitle();
		Assert.assertEquals(dt,getProperties().getProperty("demotitle"));
		captureScreen("invaliddata");
	
		
	}

}
