package ru.netology;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class CardDeliveringTest {
    // Задание 1
    @Test
    void shouldPassPositiveTest() {
        open("http://localhost:9999/");
        $$(.tab-item);
        $("[data-test-id='city']").setValue("Архангельск");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").sendKeys(currentDate + 2);
        $("[data-test-id='name']").setValue("Елена Смирнова-Кузнецова");
        $("[data-test-id='phone']").setValue("+79007777777");
        $("[data-test-id='agreement']").click();
        $("button").click();
        $(withText(Успешно!)).shoulBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='agreement']").shoulHave(currentDate + 2);
    }
}
