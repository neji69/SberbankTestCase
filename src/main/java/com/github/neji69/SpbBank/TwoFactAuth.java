package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class TwoFactAuth {
    private SelenideElement smsCodeLocator = $(byId("otp-code"));
    private SelenideElement smsButtonLocator = $(byId("login-otp-button"));

    @Step("Вводим СМС - код")
    public TwoFactAuth inputSmsCode(String smsCode) {
        smsCodeLocator.setValue(smsCode);
        return this;
    }

    @Step("Нажимаем кнопку авторизироваться по СМС коду")
    public Home clickButtonSmsAuthorization() {
        smsButtonLocator.click();
        return new Home();
    }

    public Home smsAuth(String smsCode) {
        return inputSmsCode(smsCode).clickButtonSmsAuthorization();
    }
}