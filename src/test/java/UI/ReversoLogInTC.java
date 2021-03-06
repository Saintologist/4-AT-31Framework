package UI;

import Allure.AllureTestListener;
import ReversoBO.ReversoBO;
import BrowserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({
        AllureTestListener.class
})

public class ReversoLogInTC {
    private WebDriver driver;

    @DataProvider
    Object[][] loginProvider() {
        return new Object[][]{
                {"testikVisim@gmail.com", "dfwew33"},
                {"testikVisim@gmail.com", "d232Fasd"},
        };
    }

    @BeforeTest
    void init() {
        driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "loginProvider")
    void loginTest(String login, String password) {
        ReversoBO reversoBO = new ReversoBO(driver);

        reversoBO.homePage();

        reversoBO.clickLogin();

        reversoBO.signUp(login, password);

        Assert.assertTrue(reversoBO.checkLogged());

    }

    @AfterTest
    void close() {
        driver.close();
        driver.quit();
    }
}
