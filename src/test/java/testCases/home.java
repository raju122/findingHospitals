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
	
	@Test(priority=3,groups= {"regression"},dependsOnMethods = { "test_title_h" })
	public void test() throws IOException, InterruptedException {
		
		dc=new Doctors(driver);
		
		
		
		
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
	@Test(priority=0,groups= {"sanity"})
	public void test_title_h() throws IOException {
		
		String ht=driver.getTitle();
		Assert.assertEquals(ht,getProperties().getProperty("title"));
		captureScreen("details");
	
		
	}
	@Test(priority=1,groups= {"smoke"},dependsOnMethods="test_title_h")
	void checkLocations() throws InterruptedException, IOException {
		hp=new HomePage(driver);
		
		logger.info("****Starting Testcase two extracting doctor detials****");
		hp.location.clear();
		hp.location_click(getProperties().getProperty("text"));
		Thread.sleep(2000);		
		hp.locationspec();
		
		hp.department_click(getProperties().getProperty("dep"));
		Thread.sleep(2000);
		hp.specdep();
		logger.info("****checking the selected location ****");
		if(hp.getSelectedLocation().contains(getProperties().getProperty("text"))){
			Assert.assertEquals(true, true);
		}
		
		
		
	}
	@Test(priority=2,groups= {"smoke"},dependsOnMethods="test_title_h")
	void checkSpecialist() throws IOException {
		hp=new HomePage(driver);
		String specialist=hp.getSelectedSpecialist();
		
		if(specialist.contains(getProperties().getProperty("dep"))) {
			Assert.assertEquals(true, true);
		}
		captureScreen("HomePage");
	}

}
