package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableAbstractComponent.AbstractComponent;

public class HomePage extends AbstractComponent{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// Initialization of driver from main class to local class
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement username=driver.findElement(By.id("userEmail"));
	//pagefactory
	@FindBy(id="userEmail")
	WebElement username;
	
	//driver.findElement(By.id("userPassword")
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	//driver.findElement(By.xpath("//input[@name='login']"))
	@FindBy(xpath="//input[@name='login']")
	WebElement submit ;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//Need to write the action method here based on the webelement
	public ProductCatelg loginToApplication(String email,String password) {
		username.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		
		ProductCatelg ProductCatelogue = new ProductCatelg(driver);
		return ProductCatelogue;
	}
	
	public String getErrorMessageTest() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
