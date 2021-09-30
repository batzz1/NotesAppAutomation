package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotesPage extends BasePage {


    @FindBy(id = "detail_title")
    private MobileElement txtTitle;

    @FindBy(id = "detail_content")
    private MobileElement txtContent;

    public NotesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public NotesPage setTitle(String title) {
        sendKeys(txtTitle, title);
        return this;
    }

    public NotesPage setContent(String content) {
        sendKeys(txtContent, content);
        return this;
    }
}
