package com.github.neji69.Sberbank;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DriveDepositOfferPage {
    private ElementsCollection headers = $$x("//h2[contains(@class,'product')]");


    public void checkOpenPageFromTitle(String title) {
        switchTo().window(1);
        assertThat(title())
                .as("Открылась страница " + title)
                .contains(title);
    }

    public void checkH2Text(String text) {
        assertThat(headers.get(1).getText())
                .as("На странице надпись  " + text)
                .contains(text);
    }


}
