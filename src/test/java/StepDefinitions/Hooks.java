package StepDefinitions;
 
import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.Base;
 
public class Hooks {
	public static WebDriver driver;
	public Base b=new Base();
	@Before
	public void setup() throws IOException {
		
		driver=new ChromeDriver();
    	
       	driver.get(b.getProperties().getProperty("appurl"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public WebDriver browser(String br) {
		
		 WebDriver d=new ChromeDriver();
		switch(br)
		{
		case "chrome": d=new ChromeDriver();
		                break;
		case "edge": d=new EdgeDriver();
		                 break;
		case "firefox":d=new FirefoxDriver();
		                 break;
		}
		
		return d;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
  public static  void scroll(WebElement ele) {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[1].scrollIntoView();", ele,ele);
		
	}
}