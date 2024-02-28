package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Demo;
import pageObjects.Doctors;
import pageObjects.HomePage;
import pageObjects.surgeries;
import testBase.Base;
import utilities.ExcelUtility;

public class end_to_end extends Base{
	public HomePage hp;
	public Doctors dc;
	public Demo dm;
	public surgeries sg;
	@Test(groups= {"regression"},dependsOnMethods = { "test_title_he" })
	public void endtest() throws IOException, InterruptedException {
		hp=new HomePage(driver);
		dc=new Doctors(driver);
		dm=new Demo(driver);
		sg=new surgeries(driver);
		
        //doctor details
		hp.location.clear();
		hp.location_click(getProperties().getProperty("text"));
		Thread.sleep(2000);
		hp.locationspec();
		hp.department_click(getProperties().getProperty("dep"));
		hp.specdep();
		logger.info("Loaction and specialization selected");
		dc.patientstories();
		dc.dropdownlist(dc.storieslist);
		Thread.sleep(2000);
		dc.experience();
		dc.dropdownlist(dc.experiencelist);
		Thread.sleep(2000);
		dc.filters();

		dc.dropdownlist(dc.feelist);
		Thread.sleep(2000);
		dc.filters();
		dc.dropdownlist(dc.availabilitylist);
		Thread.sleep(3000);
		dc.sort();
		dc.dropdownlist(dc.sortlist);
		logger.info("All the sortings have been done");		
		Thread.sleep(2000);
		captureScreen("details");
		dc.doctordetails(dc.details);
		logger.info("Details of the doctors have been fetched");
		
		//surgeries
		sg.home_surgeries();
		sg.listofsurgeries(sg.surgerieslist);
		logger.info("All the list of surgeries have been captured");	
		scroll(sg.getElement());
		captureScreen("surgeries");
		scroll(dm.scrollup());
		
		//invalid details
		dm.clickcs();;
		dm.clickws();
		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 0));
		captureScreen("invaliddata");
		Assert.assertEquals(dm.status(), false);
		logger.info("Invalid details have been entered");
		driver.navigate().refresh();
		
		//valid details

		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 1));
		dm.click();
		Thread.sleep(2000);
		Assert.assertEquals(dm.message(),getProperties().getProperty("thankyoumessage"));
		logger.info("Valid details enabled us to schedule a demo");	
		captureScreen("Valid login");
		
		
		
		
		
	}
	@Test(groups= {"sanity"})
	public void test_title_he() throws IOException {
		
		String ht=driver.getTitle();
		Assert.assertEquals(ht,getProperties().getProperty("title"));
		captureScreen("details");
	
		
	}

}
