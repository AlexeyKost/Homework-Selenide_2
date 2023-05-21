package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;

public class AppointmentDateFormTest {


    @Test
    void testAppointmentDate() {

        holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Краснодар");
        $("span[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("span[data-test-id=date] input").sendKeys("25.05.2023");
        $("span[data-test-id=name] input").setValue("Пупкин Иван");
        $("span[data-test-id=phone] input").setValue("+71234567890");
        $("label[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("div[data-test-id=notification]")
                .shouldHave(Condition.text("Встреча успешно забронирована на 25.05.2023"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }

}