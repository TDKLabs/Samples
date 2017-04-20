package com.tdklabs;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class SingleTest extends BaseTest {

	@Test
	public void test() throws Exception {

		open("http://www.google.com");

		$(By.name("q")).setValue("Selenide").pressEnter();

		sleep(2000); // just so we can see the browser. Remove all sleep's when CI in effect

		Assert.assertEquals(title(), "Selenide - Google Search");

	}

}
