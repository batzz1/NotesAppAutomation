package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Changelog']")
    private MobileElement lblChangeLog;

    @FindBy(id = "md_buttonDefaultPositive")
    private MobileElement btnOk;

    public SettingsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
