package testsuite;

import browsefactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class LoginTest extends BaseTest {

    String url = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        setup(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualText = driver.findElement(By.xpath(" //div[@class='example']/h2 ")).getText();
        String expectedText = "Secure Area";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void userShouldNotLoginSuccessfullyWitInValidCredentials() {

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith1");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualErrorMsg = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        String expectedErrorMsg = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }
    @Test
    public void userShouldNotLoginSuccessfullyWitInValidPassword() {

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String actualErrorMsg = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        String expectedErrorMsg = "Your password is invalid!\n" +
                "×";

        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);


    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
