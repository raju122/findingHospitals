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

public class validdetails {
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	
	Base b=new Base();
    public HomePage hp=new HomePage(driver);
    public Demo dm=new Demo(driver);
	
	@Given("practo website is open and working")
	public void practo_website_is_open_and_working() throws IOException {
	    
		String title=driver.getTitle();
		Assert.assertEquals(title,b.getProperties().getProperty("title") );
	    
	}
	
	@When("taking demo form is open")
	public void taking_demo_form_is_open() {
	   
		dm.click_corporates();
		dm.click_wellnessplan();
	 
	}
	
	@When("set detials for all fields and apply sort")
	public void set_detials_for_all_fields_and_apply_sort() throws IOException {
	    
		dm.details(ExcelUtility.readExcel(System.getProperty("user.dir")+"\\testdata\\excel.xlsx", "Sheet1", 6, 1));
	    
	}
	
	@Then("click on submit button")
	public void click_on_submit_button() {
	    
		dm.click();
	    
	}

	@Then("retrieve the thankyou message")
	public void retrieve_the_tahnkyou_message() throws IOException {
	    
		Assert.assertEquals(dm.message(),b.getProperties().getProperty("thankyoumessage"));
	   
	}
}