package com.selenium;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IponSearchTest {
    private WebDriver driver;
    private SearchPage searchPage;
    private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        // config file
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("config.properties")));
        baseUrl = prop.getProperty("baseUrl");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();

        driver.get(baseUrl);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void verifyThatSearchingWithRandomDataWorksCorrectly() {
        // Random data
        String randomSearchTerm = "laptop-" + UUID.randomUUID().toString().substring(0, 8);

        searchPage.searchFor(randomSearchTerm);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}