package browsefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public static WebDriver driver;
    String Url = "http://the-internet.herokuapp.com/login";
    public void setup(String url){

        driver = new FirefoxDriver();

        driver.get(url);
        driver.manage().window().maximize();

    }
    public void closeBrowser(){driver.quit();}

}


