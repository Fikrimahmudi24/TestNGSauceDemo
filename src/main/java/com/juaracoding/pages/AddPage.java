package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPage {
    private WebDriver driver;

    public AddPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //FindBy Add
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement btnAddOne;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement txtAddOne;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement btnAddTwo;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    WebElement txtAddTwo;

    //Method Add
    public void addCartOne(){
        btnAddOne.click();
    }
    public void addCartTwo(){
        btnAddTwo.click();
    }

    //Scraping Text
    public String getTxtAddOne(){
        return txtAddOne.getText();
    }
    public String getTxtAddTwo(){
        return txtAddTwo.getText();
    }
}
