package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableAbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// xpath("//input[@placeholder='Select Country']")
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitButton;

	// By.cssSelector(".ta-item:nth-last-of-type(1)")).
	@FindBy(css = ".ta-item:nth-last-of-type(1)")
	WebElement selectCountry;

	// By.cssSelector( ".ta-results")
	By Results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(Results);
		selectCountry.click();
		srollbyMethod();
	}
	
	public ConfirmationPage submitOrder() {
		javascriptexecutor(submitButton);
		//submitButton.click();
		return new ConfirmationPage(driver);
	}

}
