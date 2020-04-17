package com.github.neji69.Sberbank;

import com.codeborne.selenide.*;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static String ADRESS = "https://www.sberbank.ru";

    private SelenideElement tabMenu;
    private ElementsCollection tabSubMenu;


    public void openPage() {
        open(ADRESS, HomePage.class);
    }

    public void checkOpenPageFromTitle(String title) {
        assertThat(title())
                .as("Открылась страница " + title)
                .contains(title);
    }

    public void chooseMenuItem(String menuItem) {
        tabMenu = $x("//button[@aria-label='Меню " + menuItem + "']");
        tabMenu.hover();
        tabSubMenu = $$(byXpath("//button[@aria-label='Меню " + menuItem + "']/../descendant::a"));
    }

    public void chooseSubMenuItem(String putSubMenuItem) {
        for (SelenideElement subMenuItem : tabSubMenu) {
            if (subMenuItem.getText().equals(putSubMenuItem)) {
                subMenuItem.hover().shouldBe(Condition.enabled).click();
                break;
            }
        }
    }

}
