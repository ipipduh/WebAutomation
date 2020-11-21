package com.peoplentech.homework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumHomeworkWeddingWire extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SeleniumHomeworkWeddingWire.class);

    // I created before and after method with the help of Google and Youtube. It helps make sure these things run in the very beginning
    // I'll give each page a method rather than running it all together so it is easy to find mistakes or to perfect
    // Wanted to maximize the window for easier viewing
    @BeforeMethod
    public void setUp() {
        setupDriver("Chrome");
        navigateToURL("https://www.weddingwire.com/");
        driver.manage().window().maximize(); // I don't like that it is delayed - is it because of the sleepFor(3); above?
        sleepFor(2);
    }

    @Test
    public static void validateNavigateBack() {

        // visit the venues link at the top
        driver.findElement(By.xpath("(//li[@class='nav-main-item'])[2]")).click();

        sleepFor(2);

        driver.findElement(By.xpath("(//a[@class='tabsHeaderList__item'])[3]")).click();

        sleepFor(2);

        navigateBack();

        sleepFor(2);

    }

    @Test
    public static void validateSearchBar(){

        // encountered an issue where the search bar was not clearing as I attempted to send keywords through
        // used .clear (below) - you can see the difference with and without it
        // I am clearing the text and then entering my desired text
        driver.findElement(By.xpath("//input[@id='txtStrSearch']")).clear();
        driver.findElement(By.xpath("//input[@id='txtStrSearch']")).sendKeys("Waterfront");

        sleepFor(2);

        // same thing, clearing the "Boston" and entering "Barcelona"
        driver.findElement(By.xpath("//input[@aria-label='NEAR city or region']")).clear();
        driver.findElement(By.xpath("//input[@aria-label='NEAR city or region']")).sendKeys("Barcelona");
        // Question - when I run it writes the template with my key send - how do I fix that?

      //   click to search
        driver.findElement(By.xpath("//input[@id='mainSearchBtn']")).click();

        sleepFor(2);

    }

    @Test
            public static void validateAccountCreation() {

        //go to join page to sign up
        driver.findElement(By.xpath("//a[@class='header-join-link app-ua-track-event']")).click();

        sleepFor(2);

//         enter first and last name
        driver.findElement(By.xpath("//input[@name='NombreCompleto']")).sendKeys("Pippa Kramou");

        sleepFor(2);

        // email
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("philippakramou@gmail.com");

        sleepFor(2);

        // password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("abc123");

        sleepFor(2);

        // entering venue location
        driver.findElement(By.xpath("//input[@id='txtStrPoblacion']")).sendKeys("San Francisco");

        sleepFor(2);
        driver.findElement(By.xpath("//li[@class='suggest-navigation suggest-item-navigation-1']")).click();

     //   sleepFor(2);

        // calendar
        driver.findElement(By.xpath("//input[@name='Fecha']")).click();

        sleepFor(2);

        driver.findElement(By.xpath("(//span[@class='year'])[6]")).click();

        sleepFor(2);

        driver.findElement(By.xpath("//span[contains(text(),'Jun')]")).click();

        sleepFor(2);

        driver.findElement(By.xpath("(//td[@class='day '])[11]")).click();

        sleepFor(2);

        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();

        sleepFor(2);

    }

    @AfterMethod
    public void cleanUp() { // using this to close the @BeforeMethod. Cleaning up method means closing the driver.
//        closeDriver();
        driver.quit();
    }

}

