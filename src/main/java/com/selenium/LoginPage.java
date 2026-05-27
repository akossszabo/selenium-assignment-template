package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField = By.xpath("//form//input[@type='email' or @name='_username']");
    private final By passwordField = By.xpath("//form//input[@type='password' or @name='_password']");
    private final By submitLoginButton = By.xpath("//form//button[@type='submit' and contains(@class, 'btn-login')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAs(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitLoginButton).click();
    }
}