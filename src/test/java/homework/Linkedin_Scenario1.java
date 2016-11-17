package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Linkedin_Scenario1 {
    @Test
    public void Scensrio_1()

    {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\JetBrains\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.linkedin.com/");
        driver.findElement(By.id("registration-submit")).click();
        String actual_error = driver.findElement(By.xpath("//span[@class='alert-content']")).getText();
        System.out.println(driver.findElement(By.xpath("//span[@class='alert-content']")).getText());
        String expected_error = "Укажите имя";
        Assert.assertEquals(actual_error,expected_error);

        driver.quit();
    }


}
