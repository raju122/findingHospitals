package testCases;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Doctors;
import pageObjects.HomePage;
import pageObjects.surgeries;
import testBase.Base;
import utilities.ExcelUtility;

public class home extends Base{
	public HomePage hp;
	public Doctors dc;
	public List<String> doctorDetialsString;
	
	@Test(groups= {"regression"},dependsOnMethods = { "test_title_h" })
	public void test() throws IOException, InterruptedException {
		hp=new HomePage(driver);
		dc=new Doctors(driver);
		
		
		hp.location(getProperties().getProperty("text"));
		Thread.sleep(2000);
		hp.locationspec();
		hp.department(getProperties().getProperty("dep"));
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
		
		doctorDetialsString = dc.getString(dc.details);
        int listCount=1;
		for(String s:doctorDetialsString) {
			String[] data=convert_String_to_Array(s);
			
			
				
			ExcelUtility.setData(System.getProperty("user.dir")+"\\testData\\outputdata.xlsx","Sheet1",listCount,data.length,data);
			
			
			
			
			listCount++;
			
		}
		
		
		
		
	}
	@Test(groups= {"sanity"})
	public void test_title_h() throws IOException {
		
		String ht=driver.getTitle();
		Assert.assertEquals(ht,getProperties().getProperty("title"));
		captureScreen("details");
	
		
	}

}
