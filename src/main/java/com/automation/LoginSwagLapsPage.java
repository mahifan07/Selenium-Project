package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSwagLapsPage {
	WebDriver driver;
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//*[@class='btn_action']")
	WebElement loginButton;

	public LoginSwagLapsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserCreds(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		Thread.sleep(2000);
	}

	public void login() throws InterruptedException {
		loginButton.click();
		Thread.sleep(10000);
	}


}
