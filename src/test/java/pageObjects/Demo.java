package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Demo extends Basepage {
	public Demo(WebDriver driver) {
		super(driver);
		
	}
	//Locating WebElements.......
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/span[2]")
	WebElement corporates;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[3]/div[1]/span/div/div[1]/a")
	
	WebElement wellnessplan;
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement input_name;
	@FindBy(xpath="//*[@id=\"organizationName\"]")
	WebElement organization_name;
	@FindBy(xpath="//*[@id=\"contactNumber\"]")
	WebElement contactno;
	@FindBy(xpath="//*[@id=\"officialEmailId\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"organizationSize\"]")
	WebElement organizationsite;
	@FindBy(xpath="//*[@id=\"interestedIn\"]")
	WebElement interest;
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/form/button")
	WebElement submit;
	@FindBy(xpath="/html/body/div[4]/div/div/div/div[1]")
	WebElement thankyoumsg;
	
	
	
	public void click_corporates() {
		corporates.click();
	}
	public void click_wellnessplan() {
		wellnessplan.click();
	}
	
	public void details(List<String> list) {
		
		input_name.sendKeys(list.get(0));
		organization_name.sendKeys(list.get(1));
		contactno.sendKeys(list.get(2));
		email.sendKeys(list.get(3));
		Select s1=new Select(organizationsite);
		s1.selectByVisibleText(list.get(4));
		Select s2=new Select(interest);
		s2.selectByVisibleText(list.get(5));
		
		
	}
	public boolean status() {
		return submit.isEnabled();
		
	}
	public void click() {
		submit.click();
	}
	public String message() {
		return thankyoumsg.getText();
	}
	
	
}
