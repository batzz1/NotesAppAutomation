package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;

public class CheckListPage extends BasePage{

    @AndroidBy(id = "detail_title")
    private MobileElement txtTitle;

    @AndroidBy(xpath = "//android.widget.CheckBox")
    private MobileElement icnCheckBox;

    public CheckListPage(AppiumDriver driver) {
        super(driver);
    }
}
