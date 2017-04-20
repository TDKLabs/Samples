package com.tdk.web.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.optum.atk.saucelabs.ATKSauceLabs;

public class SauceTestDemo {
	
	WebDriver browser;
	ATKSauceLabs sauce_obj;

	
	@BeforeTest
	public void setUp() throws Exception {
		
		sauce_obj = new ATKSauceLabs();		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		System.out.println("SAUCE_BROWSER="+sauce_obj.get_selenium_browser());
		caps.setBrowserName(sauce_obj.get_selenium_browser());
		
		System.out.println("SAUCE_BROWSER VERSION="+sauce_obj.get_browser_version());
		caps.setVersion(sauce_obj.get_browser_version());
		
		System.out.println("SAUCE_PLATFORM="+sauce_obj.get_selenium_platform());
		caps.setCapability(CapabilityType.PLATFORM, sauce_obj.get_selenium_platform());
		
		caps.setCapability("name", this.getClass().getName());
		caps.setCapability("recordVideo", "True");
		caps.setCapability("videoUploadOnPass", "True");
		caps.setCapability("public", "private");
		
		System.out.println(System.getenv("JOB_NAME"));
		System.out.println(System.getenv("BUILD_NUMBER"));
		caps.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
		
		
		// launch browser
		browser = new RemoteWebDriver(new URL(sauce_obj.getSauceRemoteWebURL()), caps);
		this.printSessionId();
		
	}

	@Test(description = "Perform Google Search")
	public void test_to_launch_google() {
		printSessionId();
		browser.get("http://www.google.com");
		WebElement search = browser.findElement(By.name("q"));
		search.sendKeys("TD&K Labs");
		search.submit();
		this.printSessionId();

	}

	@AfterTest
	public void tearDown() {
		browser.close();
		browser.quit();
	}
	
	private void printSessionId() {
		 
	    String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
	    (((RemoteWebDriver) browser).getSessionId()).toString(), this.getClass().getName());
	    System.out.println(message);
	}

}
