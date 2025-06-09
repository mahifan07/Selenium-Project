package com.automation.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.automation.base.BaseTest;
import com.automation.pages.HomeSwagLapsPage;
import com.automation.pages.LoginSwagLapsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;

public class SwagLapsLoginSteps {
	WebDriver driver;
	LoginSwagLapsPage loginSwagLapsPage;    
	HomeSwagLapsPage homeSwagLapsPage;

	@Before
	@Step("Setup the test environment")
	public void setup() {
		BaseTest.setup();
		driver = BaseTest.driver;
	}

	@Given("user is on the swagLaps application")
	@Step("Navigate to SwagLaps application")
	public void user_is_on_the_swag_laps_application() {
		driver.get("https://www.saucedemo.com/v1/");
	}

	@When("user enters the username {string} amd password {string}")
	@Step("User enters username and password")
	public void user_enters_the_username_amd_password(String username, String password) throws InterruptedException {
		loginSwagLapsPage = new LoginSwagLapsPage(driver);
		loginSwagLapsPage.enterUserCreds(username, password);
	}

	@And("user clicks on login button")
	@Step("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginSwagLapsPage.login();
	}

	@Then("verfiy the login activity")
	@Step("Verify homepage")
	public void verfiy_the_login_activity() {
		homeSwagLapsPage = new HomeSwagLapsPage(driver);
		homeSwagLapsPage.verifyLoginActivity();
	}

	@And("add the products in the cart")
	@Step("Add products to the cart")
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
	@Step("Teardown the test environment")
	public void teardown() {
		BaseTest.teardown();
	}
}
