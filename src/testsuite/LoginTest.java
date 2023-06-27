package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setBaseUrl(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSucessfully(){

        //Click on the 'Sign In' link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text 'Welcome Back!'
        String expectedText ="Welcome Back!";
       String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Not redirected to Login page", expectedText, actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on the 'Sign In' link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("dellde@gmail.com");
        //Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("macox111");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Verify the error message 'Invalid email or password '
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error in invalid email or password", expectedText, actualText);

    }
}
