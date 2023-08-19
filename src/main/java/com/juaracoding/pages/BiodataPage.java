package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BiodataPage {
    private WebDriver driver;

    public BiodataPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //FindBy Biodata Checkout
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCode;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnContinue;
    @FindBy(xpath = "//span[@class='title']")
    WebElement txtBiodata;

    //Method Biodata Chekout
    public void biodata(String namaPertama, String namaAkhir, String kodePos){
        firstName.sendKeys(namaPertama);
        lastName.sendKeys(namaAkhir);
        zipCode.sendKeys(kodePos);
        btnContinue.click();
    }

    //Scraping Text Biodata
    public String getTxtBiodata(){
        return txtBiodata.getText();
    }
}
