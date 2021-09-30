package com.notesapp.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckListPage extends BasePage {

    @FindBy(id = "detail_title")
    private MobileElement txtTitle;

    @FindBy(xpath = "//android.widget.EditText[@index='2']")
    private List<MobileElement> lstItems;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='drawer open']")
    private MobileElement icnDrawer;

    public CheckListPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckListPage setTitle(String title) {
        sendKeys(txtTitle, title);
        return this;
    }

    public CheckListPage addItem(int numberOfItems) {
        if (numberOfItems > 1) {
            for (int i = 0; i < numberOfItems; i++) {
                lstItems.get(i).click();
                var itemTxt = "Item " + i;
                sendKeys(lstItems.get(i), itemTxt);
            }
        }
        return this;
    }

    public CheckListPage tapOnDrawer() {
        click(icnDrawer);
        return this;
    }
}
