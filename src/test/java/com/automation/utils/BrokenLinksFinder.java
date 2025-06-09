package com.automation.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinksFinder {

	@Test
	public void findBrokenLinks(WebDriver driver, String url) {
		driver.get(url);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links found: " + links.size());

		List<String> brokenLinks = new ArrayList<>();

		for (WebElement link : links) {
			String linkUrl = link.getDomAttribute("href");

			if (linkUrl != null && !linkUrl.isEmpty() && linkUrl.startsWith("http")) {
				try {
					// Open a connection to the link URL
					// and check the response code
					HttpURLConnection connection = (HttpURLConnection) new URL(linkUrl).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();

					int responseCode = connection.getResponseCode();

					if (responseCode >= 400) {
						brokenLinks.add(linkUrl + " - Response Code: " + responseCode);
					}

				} catch (IOException e) {
					brokenLinks.add(linkUrl + " - Exception: " + e.getMessage());
				}
			}
		}

		if (brokenLinks.isEmpty()) {
			System.out.println("No broken links found");
		} else {
			System.out.println("\nBroken links found:");
			for (String link : brokenLinks) {
				System.out.println(link);
			}
		}
	}
}
