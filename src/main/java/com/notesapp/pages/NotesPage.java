package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotesPage extends BasePage {


    @FindBy(id = "detail_title")
    private MobileElement txtTitle;

    @FindBy(id = "detail_content")
    private MobileElement txtContent;

    @FindBy(id = "note_title")
    private MobileElement txtNoteTitle;

    @FindBy(id = "note_content")
    private MobileElement txtNoteContent;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='drawer open']")
    private MobileElement icnDrawer;

    @FindBy(id = "menu_category")
    private MobileElement icnMenuCategory;

    @FindBy(id = "md_buttonDefaultPositive")
    private MobileElement btnAddCategory;

    @FindBy(id = "category_title")
    private MobileElement txtCategoryTitle;

    @FindBy(id = "save")
    private MobileElement btnSaveCategory;

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

    public NotesPage tapOnDrawer() {
        click(icnDrawer);
        return this;
    }

    public NotesPage addCategory(String title) {
        click(icnMenuCategory);
        click(btnAddCategory);
        sendKeys(txtCategoryTitle,title);
        return this;
    }

    public String getNoteTitle() {
        return waitForElementToBeVisible(txtNoteTitle).getAttribute("text");
    }

    public String getNoteContent() {
        return waitForElementToBeVisible(txtNoteContent).getAttribute("text");
    }

}
