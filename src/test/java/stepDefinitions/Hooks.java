package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void OpenBrowser()
    {
        System.out.println("Opening Browser");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

}
