package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Home {
    private SelenideElement buttonOverview = $(byId("bank-overview"));

    @Step("Переходим на страницу 'Обзор' ")
    public OverviewPage buttonOverviewClick() {
        buttonOverview.click();
        return new OverviewPage();
    }
}

