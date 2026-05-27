package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private final By searchBox = By.xpath("//input[contains(@placeholder, 'Keres') or contains(@class, 'search')]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String term) {
        driver.findElement(searchBox).sendKeys(term);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }
}