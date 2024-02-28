package StepDefinitions;
 
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Demo;
import pageObjects.HomePage;
import testBase.Base;
import utilities.ExcelUtility;
 
public class invaliddetails {
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	
	Base b=new Base();
    public HomePage hp=new HomePage(driver);
    public Demo dm=new Demo(driver);
	
	@Given("practo website is open")
	public void practo_website_is_open() throws IOException {
	    
		String title=driver.getTitle();
		Assert.assertEquals(title,b.getProperties().getProperty("title") );
	    
	}
	
	@When("taking demo form is open and working")
	public void taking_demo_form_is_open_and_working() {
	    
		dm.click_corporates();
		dm.click_wellnessplan();
	    
	}
	
	@When("set detials for all fields")
	public void set_detials_for_all_fields() throws IOException {
	    
		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 0));
	    
	}
 
	@Then("check whether the submit button disabled or not")
	public void check_whether_the_submit_button_disabled_or_not() {
	    
		Assert.assertEquals(dm.status(), false);
	    
	}
}