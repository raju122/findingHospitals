package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Demo;
import testBase.Base;
import utilities.ExcelUtility;

public class Validdemo extends Base {
	public Demo dm;
	@Test(groups= {"regression"},dependsOnMethods = { "test_title_validdemo" })
	
	public void test() throws IOException, InterruptedException {
		
		
		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 1));
		//Assert.assertEquals(dm.status(), true);
		dm.click();
		Thread.sleep(2000);
		Assert.assertEquals(dm.message(),getProperties().getProperty("thankyoumessage"));
		logger.info("Valid details enabled us to schedule a demo");	
		captureScreen("Valid login");
		
	}
	@Test(groups= {"sanity"})
	public void test_title_validdemo() throws IOException {
		dm=new Demo(driver);
		dm.click_corporates();
		dm.click_wellnessplan();
		String vdt=driver.getTitle();
		Assert.assertEquals(vdt,getProperties().getProperty("demotitle"));
		captureScreen("Valid login");
	
		
	}

}
