package com.tdklabs;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.WebDriverRunner;


public class BaseTest {
	public RemoteWebDriver driver;

	public static String sessionId;

	@BeforeMethod(alwaysRun=true)
	@Parameters(value={"config", "environment"})
	public void setUp(String config_file, String environment) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		Iterator it = envCapabilities.entrySet().iterator();
    	while (it.hasNext()) {
      		Map.Entry pair = (Map.Entry)it.next();
      		capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
    	}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if (capabilities.getCapability(pair.getKey().toString()) == null) {
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}


		if (DesiredCapabilities.firefox().getBrowserName().equals((String)capabilities.getCapability("browser"))) 
			driver = new FirefoxDriver(capabilities); 
		else if (DesiredCapabilities.chrome().getBrowserName().equals((String)capabilities.getCapability("browser"))) 
			driver = new ChromeDriver(capabilities);
		else if (DesiredCapabilities.safari().getBrowserName().equals((String)capabilities.getCapability("browser"))) 
			driver = new SafariDriver(capabilities);
		else if (DesiredCapabilities.internetExplorer().getBrowserName().equals((String)capabilities.getCapability("browser"))) 
			driver = new InternetExplorerDriver(capabilities);
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sessionId = driver.getSessionId().toString();

		WebDriverRunner.setWebDriver(driver);
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
