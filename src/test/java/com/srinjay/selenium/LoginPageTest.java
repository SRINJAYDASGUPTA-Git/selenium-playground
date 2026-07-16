package com.srinjay.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends BaseTest {
    @Test
    void loginPageShouldLoad() {

        openPage("pages/login.html");

        assertEquals(
                "Login - Selenium Playground",
                driver.getTitle()
        );

    }

    @Test
    void allLoginElementsShouldExist() {

        openPage("pages/login.html");

        assertTrue(driver.findElement(By.id("username")).isDisplayed());

        assertTrue(driver.findElement(By.id("password")).isDisplayed());

        assertTrue(driver.findElement(By.id("rememberMe")).isDisplayed());

        assertTrue(driver.findElement(By.id("loginBtn")).isDisplayed());

        assertTrue(driver.findElement(By.id("resetBtn")).isDisplayed());

    }

    @Test
    void shouldEnterCredentials() {

        openPage("pages/login.html");

        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("password123");

        assertEquals(
                "admin",
                driver.findElement(By.id("username"))
                        .getAttribute("value")
        );

        assertEquals(
                "password123",
                driver.findElement(By.id("password"))
                        .getAttribute("value")
        );

    }

    @Test
    void resetButtonShouldClearAllFields(){
        openPage("pages/login.html");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password123");

        driver.findElement(By.id("resetBtn")).click();

        assertEquals(
                "",
                username.getText()
        );

        assertEquals(
                "",
                password.getText()
        );
    }

    @Test
    void rememberMeShouldBeSelected(){
        openPage("pages/login.html");
        WebElement rememberMeBtn = driver.findElement(By.id("rememberMe"));

        rememberMeBtn.click();

        assertTrue(
                rememberMeBtn.isSelected()
        );
    }

    @Test
    void showPasswordBtnShouldShowPassword(){
        openPage("pages/login.html");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password123");

        driver.findElement(By.id("showPassword")).click();

        assertEquals(
                "password123",
                password.getAttribute("value")
        );
    }

    @Test
    void shouldLoginSuccessfullyWithCorrectCredentials() {
        openPage("pages/login.html");

        WebElement username_input = driver.findElement(By.id("username"));
        WebElement password_input = driver.findElement(By.id("password"));
        WebElement login_message = driver.findElement(By.id("loginMessage"));
        WebElement login_btn = driver.findElement(By.id("loginBtn"));

        username_input.sendKeys("admin");
        password_input.sendKeys("password123");
        login_btn.click();

        assertEquals(
                "Login Successful!",
                login_message.getText()
        );
    }
}
