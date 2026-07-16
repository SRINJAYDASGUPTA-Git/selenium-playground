package com.srinjay.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FormsPageTest extends BaseTest {

    @Test
    void pageShouldLoad() {

        openPage("pages/forms.html");

        assertEquals(
                "Forms - Selenium Playground",
                driver.getTitle()
        );

    }

    @Test
    void shouldFillRegistrationForm() {

        openPage("pages/forms.html");

        driver.findElement(By.id("firstName"))
                .sendKeys("Srinjay");

        driver.findElement(By.id("lastName"))
                .sendKeys("Das Gupta");

        driver.findElement(By.id("email"))
                .sendKeys("srinjay@example.com");

        driver.findElement(By.id("phone"))
                .sendKeys("9876543210");

        driver.findElement(By.id("bio"))
                .sendKeys("Learning Selenium with Java.");

        assertEquals(
                "Srinjay",
                driver.findElement(By.id("firstName"))
                        .getAttribute("value")
        );

        assertEquals(
                "Das Gupta",
                driver.findElement(By.id("lastName"))
                        .getAttribute("value")
        );

    }

    @Test
    void shouldSelectGender() {

        openPage("pages/forms.html");

        driver.findElement(By.id("male"))
                .click();

        assertTrue(
                driver.findElement(By.id("male"))
                        .isSelected()
        );

    }

    @Test
    void shouldSelectProgrammingLanguages() {

        openPage("pages/forms.html");

        driver.findElement(By.id("java")).click();
        driver.findElement(By.id("python")).click();

        assertTrue(
                driver.findElement(By.id("java"))
                        .isSelected()
        );

        assertTrue(
                driver.findElement(By.id("python"))
                        .isSelected()
        );

    }

    @Test
    void shouldSelectCountry() {

        openPage("pages/forms.html");

        WebElement dropdown =
                driver.findElement(By.id("country"));

        Select country = new Select(dropdown);

        country.selectByVisibleText("Germany");

        assertEquals(
                "Germany",
                country.getFirstSelectedOption().getText()
        );

    }

    @Test
    void shouldSelectMultipleSkills() {

        openPage("pages/forms.html");

        Select skills = new Select(
                driver.findElement(By.id("skills"))
        );

        skills.selectByVisibleText("Java");
        skills.selectByVisibleText("React");

        List<WebElement> selected =
                skills.getAllSelectedOptions();

        assertEquals(2, selected.size());

    }

    @Test
    void shouldEnterBirthDate() {

        openPage("pages/forms.html");

        WebElement date =
                driver.findElement(By.id("birthDate"));

        date.sendKeys("25-08-2004");

        assertEquals(
                "2004-08-25",
                date.getAttribute("value")
        );

    }

    @Test
    void shouldChooseFavoriteColor() {

        openPage("pages/forms.html");

        WebElement color =
                driver.findElement(By.id("favoriteColor"));

        color.sendKeys("#ff0000");

        assertEquals(
                "#ff0000",
                color.getAttribute("value")
        );

    }

    @Test
    void shouldMoveExperienceSlider() {

        openPage("pages/forms.html");

        WebElement slider =
                driver.findElement(By.id("experience"));

        slider.sendKeys("10");

    }

    @Test
    void shouldUploadResume() {

        openPage("pages/forms.html");

        String filePath = Paths.get("pom.xml")
                .toAbsolutePath()
                .toString();

        driver.findElement(By.id("resume"))
                .sendKeys(filePath);

        assertFalse(
                driver.findElement(By.id("resume"))
                        .getAttribute("value")
                        .isEmpty()
        );

    }

    @Test
    void submitButtonShouldBeEnabled() {

        openPage("pages/forms.html");

        assertTrue(
                driver.findElement(By.id("submitBtn"))
                        .isEnabled()
        );

    }

    @Test
    void shouldCountFormControls() {

        openPage("pages/forms.html");

        List<WebElement> controls =
                driver.findElements(By.className("form-control"));

        assertEquals(5, controls.size());

    }

    @Test
    void shouldCountRadioButtons() {

        openPage("pages/forms.html");

        List<WebElement> radios =
                driver.findElements(By.cssSelector("input[type='radio']"));

        assertEquals(3, radios.size());

    }

    @Test
    void shouldCountCheckboxes() {

        openPage("pages/forms.html");

        List<WebElement> checkboxes =
                driver.findElements(By.cssSelector("input[type='checkbox']"));

        assertEquals(4, checkboxes.size());

    }

}