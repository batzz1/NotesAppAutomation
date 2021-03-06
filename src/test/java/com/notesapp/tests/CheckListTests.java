package com.notesapp.tests;

import com.notesapp.BaseTest;
import com.notesapp.pages.CategoryPage;
import com.notesapp.pages.CheckListPage;
import com.notesapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckListTests extends BaseTest {

    private HomePage homePage;

    @Test
    public void addCheckListTest() {
        homePage = new HomePage(driver);
        CheckListPage checkListPage = homePage.tapOnMenu()
                .tapOnCheckList();
        checkListPage.setTitle("CheckList")
                .addItem(2)
                .tapOnDrawer();
        Assert.assertEquals("CheckList", checkListPage.getCheckListTitle());
    }

    @Test
    public void addCheckListAndCategoryTest() {
        homePage = new HomePage(driver);
        CheckListPage checkListPage = homePage.tapOnMenu()
                .tapOnCheckList();
        CategoryPage categoryPage = checkListPage.setTitle("CheckList")
                .addItem(2)
                .tapOnAddCategory();
        categoryPage.addCategory("Category")
                .tapOnDrawer();
        Assert.assertEquals("CheckList", checkListPage.getCheckListTitle());

    }
}
