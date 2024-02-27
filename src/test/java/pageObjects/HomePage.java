
package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Basepage {
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locating WebElements.......
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")
	public
	WebElement location;
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div/input")
	WebElement department;
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/div")
	WebElement specdepartment;
	@FindBy(xpath="//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]/span[1]/div")
	WebElement locationspec;
	
	public void location(String text) {
		location.click();
		location.clear();
		location.sendKeys(text);
		
	}
	public void department(String dep) throws InterruptedException {
		department.click();
		department.sendKeys(dep);
		Thread.sleep(1000);
		
		
	}
	public void specdep() {
		specdepartment.click();
	}
	public void locationspec() {
		locationspec.click();
	}
}
	