package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    
    public static void setup() {
        // System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup(); // Optional: This also works
        ChromeOptions options = new ChromeOptions();
        // Disable Chrome password manager and related services
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Launch Chrome in incognito mode and without extensions
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}