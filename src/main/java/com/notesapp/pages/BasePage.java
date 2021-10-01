package com.notesapp.pages;

import com.notesapp.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TestUtils.WAIT);
    }

    public void waitForVisibility(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(MobileElement element, String text) {
        waitForVisibility(element);
        if (element.getAttribute("text").length() > 0) {
            element.clear();
        }
        element.sendKeys(text);
    }


    public MobileElement waitForElementToBeClickable(MobileElement element, int timeoutInSeconds) {
        return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void tapOnElement(By by) {
        MobileElement element = (MobileElement) driver.findElement(by);
        TapOptions tapOptions = new TapOptions().withElement(ElementOption.element(element));
        new TouchAction(driver).tap(tapOptions).perform();
    }

    public MobileElement waitForElementToBeVisible(MobileElement element) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getAttribute(MobileElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public void waitForPresenceOfAllElements(By by) {
        sleep(3000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
