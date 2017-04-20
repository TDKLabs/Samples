package com.tdklabs.suite;
import com.tdklabs.BaseTest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SuiteTest02 extends BaseTest {

    @Test
    public void test() throws Exception {

        open("http://www.google.com");

        $(By.name("q")).setValue("selenium").pressEnter();

        sleep(2000);

        Assert.assertEquals(title(), "selenium - Google Search");

    }
}
