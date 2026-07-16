package com.srinjay.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {

    @Test
    void pageTitleShouldBeCorrect() {

        openPage("index.html");

        assertEquals(
                "Selenium Playground",
                driver.getTitle()
        );

    }

    @Test
    void startButtonShouldExist() {

        openPage("index.html");

        assertTrue(
                driver.findElement(
                        org.openqa.selenium.By.id("startButton")
                ).isDisplayed()
        );

    }

    @Test
    void navbarShouldContainFiveLinks() {

        openPage("index.html");

        List<WebElement> links =
                driver.findElements(
                        By.className("nav-link")
                );

        assertEquals(5, links.size());
    }

    @Test
    void heroTitleShouldMatch() {

        openPage("index.html");

        String title = driver
                .findElement(By.id("heroTitle"))
                .getText();

        assertEquals(
                "Practice Selenium WebDriver",
                title
        );

    }

}