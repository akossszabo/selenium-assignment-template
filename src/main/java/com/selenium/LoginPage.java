package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    // username field
    private final By emailField = By.xpath("//form//input[@type='email' or @name='_username']");
    
    // pw field
    private final By passwordField = By.xpath("//form//input[@type='password' or @name='_password']");
    
    // login button
    private final By submitLoginButton = By.xpath("//form//button[@type='submit' and contains(@class, 'btn-login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitLoginButton).click();
    }
}