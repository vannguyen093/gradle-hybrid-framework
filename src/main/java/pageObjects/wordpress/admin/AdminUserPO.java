package pageObjects.wordpress.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.admin.AdminUserPageUI;
import utilities.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminUserPO extends BasePage {
    WebDriver driver;

    public AdminUserPO(WebDriver driver) {
        this.driver = driver;
    }

    public int getUserNumberAtUI() {
        waitForElementVisible(driver, AdminUserPageUI.NUMBER_USER_TEXT);
        String totalNumber = getElementText(driver, AdminUserPageUI.NUMBER_USER_TEXT);
        return Integer.parseInt(totalNumber.split(" ")[0]);
    }

    public int getUserNumberAtDB() {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Statement statement;
        List<Integer> totalUsers = new ArrayList<Integer>();
        try {
            statement = conn.createStatement();
            String sql = "Select * from wp_users";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                totalUsers.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalUsers.size();
    }
}
