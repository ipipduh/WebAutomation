package com.peoplentech.homework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumHomeworkFive extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SeleniumHomeworkFive.class);

    // iframe, canvas,


    // DRAG AND DROP

    // POP-UP
    @Test
    public void validatePopup() {
        setupDriver("Chrome");
        navigateToURL("https://www.target.com/c/robotic-vacuums-floor-care-home-appliances/irobot/-/N-4y73oZ5v2at");
        sleepFor(2);

        // ASK HUSBAND
        driver.findElement(By.xpath("//a[contains(text(),'iRobot Roomba 675 Wi-Fi Connected Robot Vacuum')]")).click();
//
//        String popup1 = driver.switchTo().alert().getText();
//        LOGGER.info(popup1);
//
//        driver.switchTo().alert().accept();
//
//        sleepFor(2);
//        String popup2 = driver.switchTo().alert().getText();
//        LOGGER.info(popup2);

//        driver.switchTo().alert().accept();

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void checkMouseHover() {
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement fashion = driver.findElement(By.linkText("Fashion"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fashion).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Beauty")).click();

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void checkDropDown() {
        setupDriver("Chrome");
        navigateToURL("https://www.amazon.com");
        sleepFor(2);

        WebElement element = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
        Select select = new Select(element);
        select.selectByVisibleText("Alexa Skills");

        sleepFor(5);
        closeDriver();
    }

    @Test
    public void checkHoverAndThenAddToCart() {
        setupDriver("Chrome");
        navigateToURL("https://www.ebay.com");
        sleepFor(2);

        WebElement fashion = driver.findElement(By.linkText("Fashion"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fashion).build().perform();
        sleepFor(2);
        driver.findElement(By.linkText("Women's Shoes")).click();

        sleepFor(2);

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("timberland women's boltero waterproof winter boots");

        sleepFor(2);

        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        sleepFor(2);

        // issue figuring out what to use on websites when adding an item to a cart, etc.

        sleepFor(2);
        closeDriver();
    }

    @Test // error but why
    public void checkDragAndDrop() { // INTERVIEW QUESTION (create an object of the class and give 2 xpath for source and destination and add to drag and drop method, then drag and drop element to page
        setupDriver("Chrome");
        navigateToURL("https://jqueryui.com/slider/");
        sleepFor(2);

        // source AND destination xpath
        WebElement source = driver.findElement(By.xpath("//span[@style='left: 0%;']"));
        WebElement destination = driver.findElement(By.xpath("//span[@style='left: 100%;']"));

        // actions constructor
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        sleepFor(5);
        closeDriver();
    }

}
