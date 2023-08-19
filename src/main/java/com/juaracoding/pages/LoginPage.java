package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //FindBy Login dan Validasi Login
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//span[@class='title']")
    WebElement txtDashboard;

    //Negative Login
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtNegativeLogin;


    //Method Login
    public void login(String namaUser, String kataKunci){
        username.sendKeys(namaUser);
        password.sendKeys(kataKunci);
        btnLogin.click();
    }

    //Scraping Text Login
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }

    //Scraping Text Negative Login
    public String getTxtNegativeLogin(){
        return txtNegativeLogin.getText();
    }


}
