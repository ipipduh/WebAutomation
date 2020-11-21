package com.peoplentech.homework;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumHomeworkTarget extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SeleniumHomeworkTarget.class);

// the goal is to look up an item using the search bar, click button, view the item, and then navigate back
    @Test
    public void checkSearchBarAndClickButtonFunctionality() {

        setupDriver("Chrome");
        navigateToURL("https://www.target.com");
        sleepFor(2);

        // Search for A Promised Land book
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("A Promised Land");
        driver.findElement(By.xpath("//button[@class='SearchInputButton-sc-1opoijs-0 dvBrqq']")).click();

        sleepFor(2);

        closeDriver();
    }

    @Test // WHAT IS THE ERRORERRREREERRRRRR
    public void checkProductSelectionAndNavigateBack() {
        checkSearchBarAndClickButtonFunctionality();

       //  Click on the first product choice
        driver.findElement(By.xpath("(//li[@class='Col-favj32-0 bTvKos h-padding-a-none h-display-flex'])[1]")).click();

        sleepFor(2);

        navigateBack();

        sleepFor(2);

        closeDriver();
    }

    // NOTE: THIS NEEDS TO BE CORRECTED (xpath and elements)
//    @Test
//            public void AssertionTesting() {
//
//        setupDriver("Chrome");
//        navigateToURL("https://www.target.com");
//        sleepFor(2);
//
//        // search for gift ideas via the search bar
//        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Gift Ideas");
//        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();
//
//        sleepFor(2);
//
//        // constructor for currentUrl
//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);
//
////         assertion to test whether or not the url contains the information provided
////        Assert.assertTrue(currentUrl.contains("gift-ideas"));
//
//        // and/or you can assert in the following way:
//        // first one is actual, second one is expected
////           Assert.assertEquals(currentUrl, "https://www.target.com/c/gift-ideas/-/N-96d2i?lnk=snav_rd_gifts");
//
//           // try it in a way that produces false/not equal to
//        Assert.assertEquals(currentUrl, "https://www.target.com/c/gift-ideas-for-women/-/N-22vn7");
//
//            sleepFor(2);
//
//                closeDriver();
//    }


    // the goal is to add items to cart and proceed to checkout
    // NOTE THIS IS THE CORRECTED VERSION
    @Test
    public void checkCategoryDropDownAndSelectAndAddToCart() {
        setupDriver("Chrome");
        navigateToURL("https://www.target.com");

        // Clicking the Categories dropdown
        driver.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();

        sleepFor(2);

        // Selecting Gift Ideas
        driver.findElement(By.xpath("//li[@id='96d2i']")).click();

        sleepFor(2);

        // Selecting Tech HQ Category
        driver.findElement(By.xpath("//li[@id='ozsma']")).click();

        sleepFor(2);

        // Select Gamer HQ
        driver.findElement(By.xpath("//li[@id='3qopi']")).click();

        sleepFor(2);

        // Select PS5 Ad
        driver.findElement(By.xpath("(//a[@class='Link-sc-1khjl8b-0 Storyblock__StoryblockLinkWrapper-xcme7l-0 dJwaza dkYCcr h-display-flex h-flex-direction-col'])[2]")).click();

        sleepFor(2);

        // Click PS5 Product - currently shows OOS so I cannot add to cart - do a different test case with a different site or Target product
        driver.findElement(By.xpath("(//a[@class='Link-sc-1khjl8b-0 dJwaza h-display-block'])[1]")).click();

        sleepFor(2);

        closeDriver();
    }

}
