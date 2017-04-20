package com.tdklabs.suite;
import com.tdklabs.BaseTest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SuiteTest01 extends BaseTest {

	@Test
	public void test() throws Exception {

		open("http://www.google.com");

		$(By.name("q")).setValue("firefox").pressEnter();

		sleep(2000);

		Assert.assertEquals(title(), "firefox - Google Search");

	}
}
