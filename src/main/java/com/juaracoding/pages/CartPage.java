package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //FindBy Cart
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnCart;
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtCart;

    //Method Cart
    public void cart(){
        btnCart.click();
    }

    //Scraping Text Cart
    public String getTxtCart(){
        return txtCart.getText();
    }

}
