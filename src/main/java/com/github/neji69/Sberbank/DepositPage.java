package com.github.neji69.Sberbank;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DepositPage {

    private SelenideElement tabPodobratVklad = $(byXpath("//a[@data-name='podobrat']"));
    private ElementsCollection tabCheckBox = $$x("//input[contains(@data-test-id,'checkbox_checkbox')]/..");
    private ElementsCollection tabDepositOffers = $$x("//div[@data-test-id='DepositSelection_ProductCard']");
    private SelenideElement buttonDetailsOffer = $x("//a[@data-test-id='Button-white']");


    /**
     * метод проверяет количество чек-боксов на странице и их названия
     */
    public void KolichestvoCheckBoxAndTheirName(int size, List<String> dataTableCheckBox) {
        switchTo().frame("iFrameResizer0");
        tabCheckBox.shouldHaveSize(size); /** Проверяем количество чек-боксов на странице */
        tabCheckBox.shouldHave(exactTexts(dataTableCheckBox)); /** Проверяем наименования чек-боксов из таблицы-данных */
    }

    /**
     * Метод принимает имя чек-бокса и проверяет что данный чек-бокс чекед
     */
    public void checkCheckBoxChecked(String checkBoxNameOnline) {
        for (SelenideElement checkBox : tabCheckBox) {
            if (checkBox.getText().contains(checkBoxNameOnline)) {
                checkBox.find(By.xpath("./child::input")).should(Condition.checked);
            }
        }
    }

    /**
     * Метод обновляет содержимое коллекции подборки вкладов
     */
    public void refreshTabDepositOffers() {
        tabDepositOffers = $$x("//div[@data-test-id='DepositSelection_ProductCard']");
    }

    /**
     * Метод принимает, а затем проверяет количество и названия вкладов
     */
    public void sizeDepositOffersAndTheirName(int size, List<String> dataTableDepositOffers) {
        tabDepositOffers.shouldHaveSize(size); /** Проверяем количество вкладов на странице */
        tabDepositOffers.shouldHave(textsInAnyOrder(dataTableDepositOffers)); /** Проверяем наименования вкладов из таблицы-данных */
    }


    /**
     * Метод принимает название чекбокса и кликает по нему
     */
    public void checkedCheckBox(String nameCheckBox) {
        for (SelenideElement checkBox : tabCheckBox) {
            if (checkBox.getText().contains(nameCheckBox)) {
                checkBox.find(By.xpath("./child::div")).click();
            }
        }
    }

    /**
     * Метод кликает по кнопке подробнее у вклада
     */
    public void clickButtonDetailsOffer() {
        buttonDetailsOffer.click();
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
     * Метод кликает по вкладке "Подобрать вклад"
     */
    public void clickTabPodobrat() {
        tabPodobratVklad.doubleClick();
        tabPodobratVklad.doubleClick();

    }


}
