package com.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automation.BaseTest;
import com.automation.HomeSwagLapsPage;
import com.automation.LoginSwagLapsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class SwagLapsLoginSteps {
	WebDriver driver;
	LoginSwagLapsPage loginSwagLapsPage;    
	HomeSwagLapsPage homeSwagLapsPage;

	@Before
	public void setup() {
		BaseTest.setup();
		driver = BaseTest.driver;
	}

	@Given("user is on the swagLaps application")
	public void user_is_on_the_swag_laps_application() {
		driver.get("https://www.saucedemo.com/v1/");
	}

	@When("user enters the username {string} amd password {string}")
	public void user_enters_the_username_amd_password(String username, String password) throws InterruptedException {
		loginSwagLapsPage = new LoginSwagLapsPage(driver);
		loginSwagLapsPage.enterUserCreds(username, password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginSwagLapsPage.login();
	}

	@Then("verfiy the login activity")
	public void verfiy_the_login_activity() {
		homeSwagLapsPage = new HomeSwagLapsPage(driver);
		homeSwagLapsPage.verifyLoginActivity();
	}

	@Then("add the products in the cart")
	public void add_the_products_in_the_cart(DataTable productTable) throws InterruptedException {
	    List<Map<String, String>> products = productTable.asMaps(String.class, String.class);

	    for (Map<String, String> row : products) {
	        String productName = row.get("Product Name");
	        System.out.println("Adding product: " + productName);
	        homeSwagLapsPage = new HomeSwagLapsPage(driver);
			homeSwagLapsPage.addTheProductsInCart(productName);
	    }

	}

	@After
	public void teardown() {
		BaseTest.teardown();
	}
}
