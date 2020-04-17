package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class OverviewPage {
    private static final Pattern PATTERN = Pattern.compile("[0-9]{1,3} [0-9]{1,3} [0-9]{1,3}[.][0-9][0-9] [₽]"); //Проверка формата суммы на странице "обзор"
    private SelenideElement financeFreeLocator = $(By.id("can-spend"));

    @Step("Проверка, что открылась страница 'Обзор', по тайтлу ")
    public OverviewPage checkPageOpeningByTitle() {
        assertThat(title())
                .as("Открылась страница «Обзор»")
                .contains("Обзор");
        return this;
    }

    @Step("Проверка, что на странице отображается блок «Финансовая свобода» и сумма в формате '123 456 789.00' ")
    public OverviewPage checkValueContentFinanceFree() {
        assertThat(financeFreeLocator.getText())
                .as("На странице отображается блок «Финансовая свобода» и сумма в блоке 'финансовая свобода' в формате 123 456 789.00 ")
                .contains("Финансовая свобода")
                .containsPattern(PATTERN);
        return this;
    }

    @Step("Наводим на элемент и проверяем, что появляется надпись: «Моих средств» с указанием суммы в формате '123 456 789.00' ")
    public OverviewPage moveToElementAndCheckValueContentFinanceFree() {
        assertThat(financeFreeLocator.hover().getText())
                .as("Появляется надпись: «Моих средств» с указанием суммы в формате 123 456 789.00 ")
                .contains("Моих средств")
                .containsPattern(PATTERN);
        return this;
    }

}
