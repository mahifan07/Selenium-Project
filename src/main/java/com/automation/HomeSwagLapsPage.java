package com.automation;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeSwagLapsPage {
	WebDriver driver;
	private String expectedText = "Products";
	@FindBy(xpath="//*[contains(text(),'Products')]")
	WebElement menuButton;
	@FindBy(xpath="//*[@id='inventory_container']//div[@class='inventory_item_label'][.//div[contains(text(),'Sauce Labs Backpack')]]//following::button[1]")
	WebElement sauceLabsBackpack;
	@FindBy(xpath="//*[@id='inventory_container']//div[@class='inventory_item_label'][.//div[contains(text(),'Sauce Labs Bolt T-Shirt')]]//following::button[1]")
	WebElement sauceLabsBoltTShirt;
	@FindBy(xpath="//*[@id='inventory_container']//div[@class='inventory_item_label'][.//div[contains(text(),'Sauce Labs Fleece Jacket')]]//following::button[1]")
	WebElement sauceLabsFleeceJacket;

	public HomeSwagLapsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyLoginActivity() {
		String actualText = menuButton.getText();
		Assert.assertEquals(actualText, expectedText);
	}	

	public void addTheProductsInCart(String product) throws InterruptedException {
		switch (product) {
			case "Sauce Labs Backpack":
				sauceLabsBackpack.click();
				break;
			case "Sauce Labs Bolt T-Shirt":
				sauceLabsBoltTShirt.click();
				break;
			case "Sauce Labs Fleece Jacket":
				sauceLabsFleeceJacket.click();
				break;
			default:
				throw new IllegalArgumentException("Product not recognized: " + product);
		}
	}
}
