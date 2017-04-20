package com.atk.env4j.test;

import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.testng.annotations.Test;

import com.optum.atk.env4j.Env4JImpl;

public class TC99999 {
	
	@Test
	public void test() throws InvalidFileFormatException, IOException {
		
		//Loading default file
		Env4JImpl atk_conf = new Env4JImpl();
		System.out.println("--------------------------------");	
		try {
			System.out.println("JBOSSHOST= " + atk_conf.getAppHostOrServer());
			System.out.println("SELENIUM_PLATFORM= " + System.getenv("SELENIUM_PLATFORM"));
			System.out.println("SELENIUM_VERSION= " + System.getenv("SELENIUM_VERSION"));
			System.out.println("SELENIUM_BROWSER= " + System.getenv("SELENIUM_BROWSER"));
			System.out.println("SELENIUM_DRIVER= " + System.getenv("SELENIUM_DRIVER"));
			
			System.out.println("SAUCE_ONDEMAND_BROWSERS= " + System.getenv("SAUCE_ONDEMAND_BROWSERS"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
				
	}

}
