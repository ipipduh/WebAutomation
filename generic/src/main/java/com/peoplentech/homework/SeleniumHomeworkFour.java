package com.peoplentech.homework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHomeworkFour extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SeleniumHomeworkFour.class);


    @BeforeMethod
    public void setUp() {
        setupDriver("Chrome");
        navigateToURL("https://www.statefarm.com/");
        driver.manage().window().maximize();
        sleepFor(2);
    }

    @Test
    public void checkScrollToElementAndClick() {

        // Scrolling to "Careers" element at the bottom of the page
        WebElement element = driver.findElement(By.linkText("//a[contains(text(),'Careers')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Click on the Careers element link
        driver.findElement(By.xpath("//a[contains(text(),'Careers')]")).click();

        sleepFor(2);
    }


    @Test
    public void validateCareerPageAssertion() {
      //   Best practice is ONLY using validate in the method name when you are doing an assertion
        checkScrollToElementAndClick();

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.contains("Join a Community of Good Neighbors"));

//        String expected = "State Farm Jobs & Careers - State Farm®";
//        String actual = driver.getTitle();
//        Assert.assertEquals(actual,expected,"Test failed: actual does not match expected");

        sleepFor(2);
    }





    @Test
    public void checkSelectFromCategoryDropDownAndClick() {
        checkScrollToElementAndClick();

        // Opening Job Categories Dropdown
        driver.findElement(By.xpath("//a[@id='navbarDropdown-1']")).click();

        sleepFor(2);

        // Selecting Technology and UX
        driver.findElement(By.xpath("//a[contains(text(),'Technology and UX')]")).click();

        sleepFor(2);

    }


    @AfterMethod
    public void cleanUp() {
//        closeDriver();
        driver.quit();
    }
}
