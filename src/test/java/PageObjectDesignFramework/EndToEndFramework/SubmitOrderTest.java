package PageObjectDesignFramework.EndToEndFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ConfirmationPage;
import PageObject.HomePage;
import PageObject.ProductCatelg;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException, IOException {

		System.out.println("Program start");
		
		String productName = "ZARA COAT 3";
		ProductCatelg ProductCatelg = HomePage.loginToApplication("laxmanrathod2142@gmail.com", "Laxman@123");

		List<WebElement> products = ProductCatelg.getProductList();
		ProductCatelg.addProductToCart(productName);

		CartPage CartPage = ProductCatelg.goToCartPage();

		Boolean match = CartPage.VefifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckOutPage CheckOutPage = CartPage.goToCheckOut();
		CheckOutPage.selectCountry("india");

		ConfirmationPage ConfirmationPage = CheckOutPage.submitOrder();
		String ConfirmMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(ConfirmMessage);
		

		System.out.println("Program end");
	}

}
