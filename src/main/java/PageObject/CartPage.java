package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableAbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// By.cssSelector(".totalRow button")
	@FindBy(css = ".totalRow button")
	WebElement checkoutele;

	//By.cssSelector(".cartSection h3")
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public boolean VefifyProductDisplay(String productName) {
		Boolean match=cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
	}
	
	public CheckOutPage goToCheckOut() {
		checkoutele.click();
		return new CheckOutPage(driver);
	}
	

}
