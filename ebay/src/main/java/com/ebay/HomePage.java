package com.ebay;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.base.TestBase.*;

public class HomePage {

    @FindBy(id = "gh-ac")
    private WebElement searchBar;

    public void clickOnSearchBar() {
        searchBar.click(); // verify ability to click on the search bar
        sleepFor(2);
    }

    public void typeOnSearchBar() {
        LOGGER.info("sending keys : timberland women's boltero waterproof winter boots");
        searchBar.sendKeys("timberland women's boltero waterproof winter boots");
        sleepFor(2);
    }

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click(); // search button click feature
        sleepFor(2);
        navigateBack(); // verify navigation back to homepage
        sleepFor(2);
    }

    public void scrollDownAndUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll all the way down
        sleepFor(4);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)"); // scroll all the way back up
        sleepFor(4);
    }

    @FindBy(xpath = "(//a[text()= 'Fashion'])[2]")
    private WebElement hoverCheck;

    public void hoverMouse() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverCheck).build().perform();
        sleepFor(2);
    }

    @FindBy(linkText = "Women's Shoes")
    private WebElement hoverClick;

    public void hoverMouseAndClick() {
        hoverClick.click();
    sleepFor(2);
    navigateBack(); // return to the homepage
    sleepFor(2);
    }

    @FindBy(id="gh-cat")
    private WebElement dropDown;

    public void clickdropDownAndSelect(){
        dropDown.click();
        sleepFor(2);
        Select select = new Select(dropDown);
        select.selectByVisibleText("Travel");
        sleepFor(2);
    }

    @FindBy(id="gh-ac")
    private WebElement searchEntry;

    public void dropDownSearchEntry(){
        searchEntry.click();
        sleepFor(2);
        LOGGER.info("sending keys : Vacation Packages");
        searchEntry.sendKeys("Vacation Packages");
        sleepFor(2);
        searchButton.click();
        sleepFor(2);
        navigateBack();
        sleepFor(2);
    }

    @FindBy(linkText = "eBay for Charity")
    private WebElement scrollElement;

    public void scrollToElement(){
        JavascriptExecutor js = (JavascriptExecutor) driver; // driver will have capability of Javascript
        js.executeScript("arguments[0].scrollIntoView(true);",scrollElement);
        sleepFor(2);
        scrollElement.click();
        sleepFor(2);
        navigateBack();
        sleepFor(2);
    }

    // will not get to do account login/out/acct creation/add/remove from cart/check boxes, or pop-ups
    // also won't be able to do drag and drop or iframe using ebay

}
