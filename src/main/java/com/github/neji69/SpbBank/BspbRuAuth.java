package com.github.neji69.SpbBank;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BspbRuAuth {

    private SelenideElement usernameElement = $(byName("username"));
    private SelenideElement passwordElement = $(byName("password"));
    private SelenideElement loginButtonElement = $(".btn-primary");

    @Step("Вводим логин пользователя")
    public BspbRuAuth inputLogin(String login) {
        usernameElement.setValue(login);
        return this;
    }

    @Step("Вводим пароль пользователя")
    public BspbRuAuth inputPassword(String password) {
        passwordElement.setValue(password);
        return this;
    }

    @Step("Нажимаем кнопку авторизации")
    public TwoFactAuth clickButtonAuthorization() {
        loginButtonElement.click();
        return new TwoFactAuth();
    }

    public TwoFactAuth authorize(String login, String password) {
        return inputLogin(login).inputPassword(password).clickButtonAuthorization();
    }
}
