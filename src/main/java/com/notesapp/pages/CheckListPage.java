package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckListPage extends BasePage {

    @FindBy(id = "detail_title")
    private MobileElement txtTitle;

    @FindBy(xpath = "//android.widget.EditText[@index='2']")
    private List<MobileElement> lstItems;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='drawer open']")
    private MobileElement icnDrawer;

    @FindBy(id = "note_title")
    private MobileElement txtCheckListTitle;

    @FindBy(id = "menu_category")
    private MobileElement icnMenuCategory;

    public CheckListPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CheckListPage setTitle(String title) {
        sendKeys(txtTitle, title);
        return this;
    }

    public CheckListPage addItem(int numberOfItems) {
        if (numberOfItems > 1) {
            for (int i = 0; i < numberOfItems; i++) {
                lstItems.get(i).click();
                String itemTxt = "Item " + i;
                sendKeys(lstItems.get(i), itemTxt);
            }
        }
        return this;
    }

    public CheckListPage tapOnDrawer() {
        click(icnDrawer);
        return this;
    }

    public String getCheckListTitle() {
        return waitForElementToBeVisible(txtCheckListTitle).getAttribute("text");
    }

    public CategoryPage tapOnAddCategory() {
        click(icnMenuCategory);
        return new CategoryPage(driver);
    }
}
