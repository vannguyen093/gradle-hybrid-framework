package com.wordpress.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.PageGenerateManager;
import pageObjects.wordpress.admin.*;

public class User_01_View_User extends BaseTest {

    @Parameters({"browser", "urlAdmin"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl) {
        adminUserName = "vannguyen093";
        adminPassword = "changchang710";

        log.info("Pre-Condition - Step 01: Open browser and admin url");
        driver = getBrowserDriverA(browserName, adminUrl);
        adminLoginPageObject = PageGenerateManager.getAdminLoginPage(driver);

        log.info("Pre-Condition - Step 02: Enter to Username textbox with value is " + adminUserName);
        adminLoginPageObject.enterToUsernameTextbox(adminUserName);

        log.info("Pre-Condition - Step 03: Enter to Password textbox with value is " + adminPassword);
        adminLoginPageObject.enterToPasswordTextbox(adminPassword);

        log.info("Pre-Condition - Step 04: Click to 'Login' button");
        adminDashboardPage = adminLoginPageObject.clickToLoginButton();

    }

    @Test
    public void TC_01_View_User() {
        log.info("View_User - Step 01: Click to 'User' menu link");
        adminUserPage = adminDashboardPage.clickToUserMenuLink();

        log.info("View_User - Step 02: Get all user at UI");
        int userNumberAtUI = adminUserPage.getUserNumberAtUI();

        log.info("View_User - Step 03: Get all user at DB");
        int userNumberAtDB = adminUserPage.getUserNumberAtDB();

        log.info("View_User - Step 04: Verify user number is exactly");
        verifyEquals(userNumberAtUI, userNumberAtDB);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

    private WebDriver driver;
    private String adminUserName, adminPassword;
    AdminLoginPO adminLoginPageObject;
    AdminDashboardPO adminDashboardPage;
    AdminPostSearchPO adminPostSearchPage;
    AdminPostAddNewOrUpdatePO adminPostAddNewOrUpdatePage;
    AdminUserPO adminUserPage;
}
