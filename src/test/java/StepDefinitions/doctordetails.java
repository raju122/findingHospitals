package StepDefinitions;
 
import java.io.IOException;
 
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Doctors;
import pageObjects.HomePage;
import pageObjects.surgeries;
import testBase.Base;
 
 
 
public class doctordetails {
	Hooks h=new Hooks();
	public WebDriver driver=h.getDriver();
	
	Base b=new Base();
    public HomePage hp=new HomePage(driver);
    public Doctors dc=new Doctors(driver);
    public surgeries sg=new surgeries(driver);
	
	
	@Given("practo website is open and working fine")
	public void practo_website_is_open_and_working_fine() throws IOException {
		String title=driver.getTitle();
		Assert.assertEquals(title,b.getProperties().getProperty("title") );
	    
		
	}
 
	@When("provide location and specialisation details")
	public void provide_location_and_specialisation_details() throws InterruptedException, IOException {
	    hp.location(b.getProperties().getProperty("text"));
	    Thread.sleep(2000);
		hp.locationspec();
		hp.department(b.getProperties().getProperty("dep"));
		hp.specdep();
	    
		
	}
 
	@When("Apply all filter options")
	public void Apply_all_filter_options() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
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
		
		Thread.sleep(2000);
		
	    
	}
 
	@Then("print first five doctor detials")
	public void print_first_five_doctor_detials() {
	    // Write code here that turns the phrase above into concrete actions
		dc.doctordetails(dc.details);
	    
	}
 
	@Then("click on surgiers")
	public void click_on_surgiers() {
	    // Write code here that turns the phrase above into concrete actions

		sg.home_surgeries();
		
	   
	}
 
	@Then("print list of surgiers")
	public void print_list_of_surgiers() {
	    // Write code here that turns the phrase above into concrete actions
		sg.listofsurgeries(sg.surgerieslist);
	  
	}
}