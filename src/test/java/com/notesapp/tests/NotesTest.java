package com.notesapp.tests;

import com.notesapp.BaseTest;
import com.notesapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NotesTest extends BaseTest {

    private HomePage homePage;


    @Test
    public void addTextNoteTest() throws InterruptedException {
        homePage = new HomePage(driver);
        var notesPage = homePage.tapOnMenu()
                .tapOnTextNote();
        notesPage.setTitle("Appium Test")
                .setContent("Running Test")
                .tapOnDrawer();
        Assert.assertEquals("Appium Test", notesPage.getNoteTitle());
        Assert.assertEquals("Running Test", notesPage.getNoteContent());
    }

    @Test
    public void addNotesAndCategoryTest() {
        homePage = new HomePage(driver);
        homePage = new HomePage(driver);
        var notesPage = homePage.tapOnMenu()
                .tapOnTextNote();
        var categoryPage = notesPage.setTitle("Appium Test")
                .setContent("Running Test")
                .tapOnAddCategory();
        categoryPage.addCategory("Category")
                .tapOnDrawer();
        Assert.assertEquals("Appium Test", notesPage.getNoteTitle());
        Assert.assertEquals("Running Test", notesPage.getNoteContent());
    }
}
