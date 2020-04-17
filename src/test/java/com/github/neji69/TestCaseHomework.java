package com.github.neji69;

import com.github.neji69.SpbBank.BspbRuAuth;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestCaseHomework {
    //Данные для теста (логин,пароль и смс для авторизации)
   private static final String LOGIN = "demo";
   private static final String PASSWORD = "demo";
   private static final String SMS_CODE = "0000";

    @Test
    @Owner(value = "Ленчевский Ян")
    @Severity(value = SeverityLevel.MINOR)
    public void testCase22() {

        open("https://idemo.bspb.ru", BspbRuAuth.class)
                .authorize(LOGIN, PASSWORD)
                .smsAuth(SMS_CODE)
                .buttonOverviewClick()
                .checkPageOpeningByTitle()
                .checkValueContentFinanceFree()
                .moveToElementAndCheckValueContentFinanceFree();
    }
}

