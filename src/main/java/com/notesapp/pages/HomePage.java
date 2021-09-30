package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    private By btnMenu = MobileBy.id("fab_expand_menu_button");
    private By btnCheckList = MobileBy.id("fab_checklist");
    private By btnTextNote = MobileBy.id("fab_note");


    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomePage tapOnMenu() {
        tapOnElement(btnMenu);
        return this;
    }

    public CheckListPage tapOnCheckList() {
        tapOnElement(btnCheckList);
        return new CheckListPage(driver);
    }


    public NotesPage tapOnTextNote() {
        tapOnElement(btnTextNote);
        return new NotesPage(driver);
    }
}
