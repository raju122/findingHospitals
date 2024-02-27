package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class surgeries extends Basepage {

	public surgeries(WebDriver driver) {
		super(driver);
		
	}
	//Locating WebElements.......
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div/div/p")
	public
	List<WebElement> surgerieslist;
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/h1")
	WebElement scrolldown;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	WebElement surgeries;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[5]/a/div[1]")
	WebElement homesurgeries;
	
	
	public void click_surgeries() {
		surgeries.click();
	}
	public void home_surgeries() {
		homesurgeries.click();
	}
	
	
	public void listofsurgeries(List<WebElement> surgerieslist) {
		for(int i=0;i<surgerieslist.size();i++) {
			System.out.println(surgerieslist.get(i).getText());
		}
	}
	public WebElement getElement() {
		return scrolldown;
	}
	

}
