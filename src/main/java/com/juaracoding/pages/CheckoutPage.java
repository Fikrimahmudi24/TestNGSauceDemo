package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //FindBy Checkout
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtCheckout;

    //Method Checkout
    public void checkout(){
        btnCheckout.click();
    }

    //Scraping Text Checkout
    public String getTxtCheckout(){
        return txtCheckout.getText();
    }
}
