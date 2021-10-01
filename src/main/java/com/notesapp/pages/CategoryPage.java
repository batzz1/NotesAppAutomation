package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage extends BasePage {

    @FindBy(id = "menu_category")
    private MobileElement icnMenuCategory;

    @FindBy(id = "md_buttonDefaultPositive")
    private MobileElement btnAddCategory;

    @FindBy(id = "category_title")
    private MobileElement txtCategoryTitle;

    @FindBy(id = "save")
    private MobileElement btnSaveCategory;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='drawer open']")
    private MobileElement icnDrawer;

    public CategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CategoryPage addCategory(String category) {
        click(btnAddCategory);
        sendKeys(txtCategoryTitle, category);
        click(btnSaveCategory);
        return this;
    }

    public CategoryPage tapOnDrawer() {
        click(icnDrawer);
        return this;
    }
}
