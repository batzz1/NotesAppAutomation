package com.notesapp.tests;

import com.notesapp.BaseTest;
import com.notesapp.pages.HomePage;
import org.testng.annotations.Test;

public class CheckListTests extends BaseTest {

    private HomePage homePage;

    @Test
    public void addCheckListTest() {
        homePage = new HomePage(driver);
        var checkListPage = homePage.tapOnMenu()
                .tapOnCheckList();
        checkListPage.setTitle("CheckList")
                .addItem(2)
                .tapOnDrawer();
    }

}
