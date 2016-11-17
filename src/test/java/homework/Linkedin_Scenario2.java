package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Linkedin_Scenario2 {
    @Test
    public void Scenario2() throws InterruptedException
    {
        System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\JetBrains\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        driver.findElement(By.id("reg-firstname")).sendKeys("Rostyslav");
        driver.findElement(By.id("reg-lastname")).sendKeys("Biliaiev");
        driver.findElement(By.id("reg-email")).sendKeys("123123@ru");
        driver.findElement(By.id("reg-password")).sendKeys("123123asdfgmgfd");
        driver.findElement(By.id("registration-submit")).click();
        String actual_error = driver.findElement(By.xpath("//span[@class='alert-content']")).getText();
        //System.out.println(driver.findElement(By.xpath("//span[@class='alert-content']")).getText());
        String expected_error = "Укажите действительный адрес электронной почты";
        Assert.assertEquals(actual_error,expected_error);
        driver.quit();



    }
}

