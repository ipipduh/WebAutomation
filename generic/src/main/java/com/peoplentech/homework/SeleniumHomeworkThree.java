package com.peoplentech.homework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumHomeworkThree extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SeleniumHomeworkThree.class);

    @Test
    public void validateScroll() {
        setupDriver("Chrome");
        navigateToURL("https://www.ikea.com/us/en/");
        sleepFor(2);

        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("window.scrollBy(0,1000)");

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void validateElementScroll() { // ERROR WHY????
        setupDriver("Chrome");
        navigateToURL("https://www.ikea.com/us/en/");
        sleepFor(2);

        WebElement element = driver.findElement(By.linkText("This is IKEA"));
        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        sleepFor(5);
        closeDriver();
    }

    @Test(enabled = false)
    public void validateiFrame() {
        setupDriver("Chrome");
        navigateToURL("https://whatyouseewhenyoudie.ytmnd.com/");
        sleepFor(2);

        //   frame ID
        //     frame Name
        //    frame Index
        driver.switchTo().frame("frame1");
        // perform all actions that required in the child page
        driver.findElement(By.xpath("xpath from child page")).click();

        driver.switchTo().defaultContent();
        //perform all actions required in the main page
        driver.findElement(By.xpath("xpath from main page")).click();

        sleepFor(2);
        closeDriver();

        // you can use YouTube or Tik Tok as an example, and find others to try for homework
    }
}
