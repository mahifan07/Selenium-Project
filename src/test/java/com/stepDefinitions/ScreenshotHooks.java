package com.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.BaseTest;

import io.cucumber.java.AfterStep;

public class ScreenshotHooks {

   WebDriver driver;
   private String testName;
   
   public ScreenshotHooks(){
   }
   
   @AfterStep
   public void takeScreenshot(){
	   WebDriver driver = BaseTest.getDriver();
	   if (driver == null) {
		   System.out.println("Driver is not initialized. Cannot take screenshot.");
	   }else {
		   System.out.println("Taking screenshot...");
		   TakesScreenshot ts = (TakesScreenshot) driver;
		   try {
		   File srcFile = ts.getScreenshotAs(OutputType.FILE);
		   String testName = generateRandomTestName();
		   File destFile = new File("Screenshots/"+testName+".png");
		   FileUtils.copyFile(srcFile, destFile);
		   }
		   catch (IOException e) {
			   e.printStackTrace();
		   }
		   catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
   }
   
   public String generateRandomTestName() {
	   this.testName = "test_" + System.currentTimeMillis();
	   System.out.println("" + "Generated Test Name: " + this.testName);
	   return testName;
   }
}

