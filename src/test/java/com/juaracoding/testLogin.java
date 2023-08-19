package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLogin {

    WebDriver driver;
    LoginPage loginPage;
    AddPage addPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    BiodataPage biodataPage;
    FinishPage finishPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        addPage = new AddPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        biodataPage = new BiodataPage();
        finishPage = new FinishPage();
        logoutPage = new LogoutPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void validLoginTest(){
        loginPage.login("standard_user", "secret_sauce");
        String actual = loginPage.getTxtDashboard();
        String expected = "Products";
        Assert.assertEquals(actual, expected);
        System.out.println("Login test");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 2)
    public void validAddTestOne(){
        addPage.addCartOne();
        String actual = addPage.getTxtAddOne();
        String expected = "Remove";
        Assert.assertEquals(actual, expected);
        System.out.println("Add One to Cart Test");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 3)
    public void validAddTestTwo(){
        addPage.addCartTwo();
        String actual = addPage.getTxtAddTwo();
        String expected = "Remove";
        Assert.assertEquals(actual, expected);
        System.out.println("Add Two to Cart Test");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 4)
    public void validCartTest(){
        cartPage.cart();
        String actual = cartPage.getTxtCart();
        String expected = "Your Cart";
        Assert.assertEquals(actual, expected);
        System.out.println("Assert/Validasi Cart");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 5)
    public void validCheckoutTest(){
        checkoutPage.checkout();
        String actual = checkoutPage.getTxtCheckout();
        String expected = "Checkout: Your Information";
        Assert.assertEquals(actual, expected);
        System.out.println("Assert/Validasi Checkout");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 6)
    public void validDanNegatifBiodataTest(){
        biodataPage.biodata("fikri", "mahmudi", "22325");
        String actual = biodataPage.getTxtBiodata();
        String expected = "Checkout: Overview";
        Assert.assertEquals(actual, expected);
        System.out.println("Assert/Validasi dan Negatif Biodata");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 7)
    public void validFinishTest(){
        finishPage.finish();
        String actual = finishPage.getTxtFinish();
        String expected = "Checkout: Complete!";
        Assert.assertEquals(actual, expected);
        System.out.println("Assert/Validasi Finish");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 8)
    public void validLogoutTest(){
        logoutPage.logout();
        String actual = logoutPage.getTxtLogout();
        String expected = "Accepted usernames are:";
        Assert.assertEquals(actual, expected);
        System.out.println("Logout test");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

    @Test(priority = 9)
    public void negatifLoginTest(){
        loginPage.login("standard_userr", "secret_sauce");
        String actual = loginPage.getTxtNegativeLogin();
        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actual, expected);
        System.out.println("Negative Login test");
        System.out.println(actual + " = " + expected);
        System.out.println("--------------------");
    }

}
