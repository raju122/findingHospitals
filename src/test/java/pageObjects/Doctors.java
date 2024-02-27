package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Doctors extends Basepage {

	public Doctors(WebDriver driver) {
		super(driver);
		
	}
	//Locating WebElements.......
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]")
	WebElement patientstories;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[2]/ul/li")
	public List<WebElement> storieslist;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]")
	public
	WebElement experience;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/ul/li/span")
	public
	List<WebElement> experiencelist;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[4]/span/span")
	WebElement filters;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[1]/div/label/span/span")
	public
	List<WebElement> feelist;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[2]/div/label/span/span")
	
	
	public
	List<WebElement> availabilitylist;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/span")
	WebElement sort;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/ul/li")
	public
	List<WebElement> sortlist;
	@FindBy(xpath="//*[@class=\"info-section\"]")
	public
	List<WebElement> details;
	
	//*[@id="container"]/div/div[3]/div/div/header/div[1]/div/div[6]/div/div/div/span
	
	public void patientstories() {
		patientstories.click();
	}
	public void experience() {
		experience.click();
	}
	public void filters() {
		filters.click();
	}
	public void sort() {
		sort.click();
	}
	public void dropdownlist(List<WebElement> dropDown) {
		dropDown.get(0).click();
		
	}
	public void doctordetails(List<WebElement> details) {
		for(int i=1;i<6;i++) {
			System.out.println(details.get(i).getText());
		}
	}
	
	public List<String> getString(List<WebElement> doc){
		List<String> s=new ArrayList<String>();
		for(int i=0;i<5;i++) {
			s.add(doc.get(i).getText());
			
		}
		return s;
	}
	
	

}
