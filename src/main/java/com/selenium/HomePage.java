package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    //login button
    private By loginButton = By.xpath("//span[contains(normalize-space(.), 'Bejelentkezés')]");

    // accept cookies button
    private By acceptCookiesButton = By.xpath("//button[contains(text(), 'Elfogadom') or contains(text(), 'Összes elfogadása')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookiesIfPresent() {
        try {
            driver.findElement(acceptCookiesButton).click();
        } catch (Exception e) {
            System.err.println("Accept Cookies button not found or not clickable: " + e.getMessage());
            throw e;
        }
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (Exception e) {
            System.err.println("Login button not found or not clickable: " + e.getMessage());
            throw e;
        }
    }
}