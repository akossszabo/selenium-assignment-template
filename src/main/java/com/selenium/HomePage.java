package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private By loginButton = By.xpath("//span[contains(normalize-space(.), 'Bejelentkezés')]");
    private By acceptCookiesButton = By.xpath("//button[contains(text(), 'Elfogadom') or contains(text(), 'Összes elfogadása')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesIfPresent() {
        try {
            driver.findElement(acceptCookiesButton).click();
        } catch (Exception e) {
            System.err.println("Accept Cookies button not found or not clickable: " + e.getMessage());
        }
    }

    public void clickLogin() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            System.err.println("Login button not found: " + e.getMessage());
            throw e;
        }
    }
}