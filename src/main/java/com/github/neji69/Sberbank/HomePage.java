package com.github.neji69.Sberbank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    private static String ADRESS = "https://www.sberbank.ru";

    private SelenideElement tabMenu;
    private ElementsCollection tabSubMenu;


    public void openPage() {
        open(ADRESS, HomePage.class);
    }

    /**
     * Метод проверяет соответствие тайтла открытой страницы
     */
    public void checkOpenPageFromTitle(String title) {
        assertThat(title())
                .as("Открылась страница " + title)
                .contains(title);
    }

    /**
     * Метод принимает текстовое название конкретного Меню и выбирает его
     */
    public void chooseMenuItem(String menuItem) {
        tabMenu = $x("//button[@aria-label='Меню " + menuItem + "']");
        tabMenu.hover();
        tabSubMenu = $$(byXpath("//button[@aria-label='Меню " + menuItem + "']/../descendant::a"));
    }

    /**
     * Метод принимает текстовое название под-меню и кликает по нему
     */
    public void chooseSubMenuItem(String putSubMenuItem) {
        for (SelenideElement subMenuItem : tabSubMenu) {
            if (subMenuItem.getText().equals(putSubMenuItem)) {
                subMenuItem.hover().shouldBe(Condition.enabled).click();
                break;
            }
        }
    }

}
