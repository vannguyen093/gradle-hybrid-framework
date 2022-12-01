package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.admin.*;
import pageObjects.wordpress.user.UserHomePO;
import pageObjects.wordpress.user.UserPostDetailPO;
import pageObjects.wordpress.user.UserPostSearchPO;

public class PageGenerateManager {
    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }
    public static AdminPostSearchPO getAdminPostSearchPage(WebDriver driver) {
        return new AdminPostSearchPO(driver);
    }
    public static AdminPostAddNewOrUpdatePO getAdminPostAddNewPage(WebDriver driver) {
        return new AdminPostAddNewOrUpdatePO(driver);
    }
    public static AdminUserPO getAdminUserPage(WebDriver driver) {
        return new AdminUserPO(driver);
    }
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }
    public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
        return new UserPostDetailPO(driver);
    }
    public static UserPostSearchPO getUserPostSearchPage(WebDriver driver) {
        return new UserPostSearchPO(driver);
    }
}
