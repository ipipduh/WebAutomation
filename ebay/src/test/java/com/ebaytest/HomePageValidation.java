package com.ebaytest;


import com.ebay.HomePage;
import com.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageValidation extends TestBase {

        @Test
    public void validateUserBeingAbleToTypeOnSearchBar() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnSearchBar();
        homePage.typeOnSearchBar();
        homePage.clickSearchButton();
        homePage.scrollDownAndUp();
        homePage.hoverMouse();
        homePage.hoverMouseAndClick();
        homePage.clickdropDownAndSelect();
        homePage.dropDownSearchEntry();
        homePage.scrollToElement();

    }


//    @BeforeMethod
//    public void initElements() {
//        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//
//    }
//    @Test
//    public void TypeOnSearchBar(){
//
//    }

}
