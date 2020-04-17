package com.github.neji69.Cucumber.stepdefs;

import com.github.neji69.Sberbank.DepositPage;
import com.github.neji69.Sberbank.DriveDepositOfferPage;
import com.github.neji69.Sberbank.HomePage;
import io.cucumber.java.ru.*;

import java.util.List;


public class Sberbank {
    HomePage homePage = new HomePage();
    DepositPage depositPage = new DepositPage();
    DriveDepositOfferPage driveDepositOfferPage = new DriveDepositOfferPage();

    @Дано("перейти на {string}")
    public void openUrl(String string) {
        homePage.openPage();

    }

    @Тогда("проверка перехода, название страницы {string}")
    public void checkOpenPageFromTitle(String title) {
        homePage.checkOpenPageFromTitle(title);
    }

    @Затем("перейти через верхнее меню во {string}")
    public void goToMenuAndClickDeposit(String string) {
        homePage.chooseMenuItem("Вклады");
        homePage.chooseSubMenuItem("Вклады");
    }

    @Затем("перейти на вкладку «Подобрать вклад»")
    public void clickToPickUpDeposit() {
        depositPage.checkOpenPageFromTitle("«Сбербанк» - Подбор вкладов");
        depositPage.clickTabPodobrat();

    }

    @Дано("{int} чек-бокса")
    public void checkVisibleCheckBox(int size, List<String> dataTable) {
        depositPage.KolichestvoCheckBoxAndTheirName(size, dataTable);
    }

    @Тогда("проверка, установлен чекбокс {string}")
    public void checkSelectetCheckBoxValue(String nameCheckBox) {
        depositPage.checkCheckBoxChecked(nameCheckBox);
    }

    @Тогда("{int} вкладки")
    public void CheckVisibleDeposit(int size, List<String> dataTableDepositOffers) {
        depositPage.sizeDepositOffersAndTheirName(size, dataTableDepositOffers);
    }

    @Затем("отключить чек-бокс {string} и выбрать {string} и {string}")
    public void выбрать_чек_боксы_Хочу_снимать_и_Хочу_пополнять(String nameCheckBox1, String nameCheckBox2, String nameCheckBox3) {
        depositPage.checkedCheckBox(nameCheckBox1);
        depositPage.checkedCheckBox(nameCheckBox2);
        depositPage.checkedCheckBox(nameCheckBox3);
    }

    @Тогда("проверка остался только {int} вклад")
    public void leftOnlyContributionControl(int size, List<String> dataTableDepositOffers) {
        depositPage.refreshTabDepositOffers();
        depositPage.sizeDepositOffersAndTheirName(size, dataTableDepositOffers);
    }

    @Затем("нажать на кнопку Подробнее вклада Управляй")
    public void clickOnContribButtonControl() {
        depositPage.clickButtonDetailsOffer();
    }

    @Тогда("проверка, в новом окне открылась вкладка {string}")
    public void checkInNewWindowOpenedTab(String title) {
        driveDepositOfferPage.checkOpenPageFromTitle(title);
    }

    @Тогда("на странице отображается надпись {string}")
    public void onPageIsDisplayed(String text) {
        driveDepositOfferPage.checkH2Text(text);
    }
}
