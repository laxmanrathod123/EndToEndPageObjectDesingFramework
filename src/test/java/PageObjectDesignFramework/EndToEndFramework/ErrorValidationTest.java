package PageObjectDesignFramework.EndToEndFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.ProductCatelg;
import TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void LoginErrorValidation() throws InterruptedException, IOException {

		String productName = "ZARA COAT 3";
		HomePage.loginToApplication("laxmanrathod4822@gmail.com", "Lucky123");
		Assert.assertEquals("Incorrect email or password.", HomePage.getErrorMessageTest());

	}  
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {

		
		String productName = "ZARA COAT 3";
		ProductCatelg ProductCatelg = HomePage.loginToApplication("laxmanrathod2142@gmail.com", "Laxman@123");

		List<WebElement> products = ProductCatelg.getProductList();
		ProductCatelg.addProductToCart(productName);

		CartPage CartPage = ProductCatelg.goToCartPage();

		Boolean match = CartPage.VefifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

		
		

	
	}
	
	

}
