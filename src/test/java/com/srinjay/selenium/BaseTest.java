package com.srinjay.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

    }

    protected void openPage(String page) {

        String path = "https://selenium.srinjaydg.in/"+page;

        driver.get(path);

    }

    @AfterEach
    void tearDown() {

        if(driver != null){

            driver.quit();

        }

    }

}