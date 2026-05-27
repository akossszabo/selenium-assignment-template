package com.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IponLoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.get("https://ipon.hu");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginAttempt() {
        // Page title ellenőrzés (1 alap pont)
        String title = driver.getTitle();
        assertTrue(title.toLowerCase().contains("ipon"), "Az oldal címe nem tartalmazza az ipon szót!");

        org.openqa.selenium.WebElement searchInput =
                driver.findElement(org.openqa.selenium.By.xpath("//input[contains(@placeholder, 'Keres') or contains(@class, 'search')]"));
        assertTrue(searchInput.isDisplayed(), "A keresőmező nem látható a főoldalon!");

        homePage.acceptCookiesIfPresent();
        //assertTrue(driver.getPageSource().contains("i n"), "Nem található a szöveg az oldalon!");
        homePage.clickLogin();
        loginPage.loginAs("teszt.elek@valami.hu", "TitkosJelszo123");

        driver.navigate().back(); // back to homepage
        driver.navigate().forward();

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}