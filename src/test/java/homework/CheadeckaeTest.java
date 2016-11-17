package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class CheadeckaeTest {
    @BeforeTest

    @Test


    public void listCheesecakes() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\JetBrains\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.thecheesecakefactory.com/");
        driver.findElement(By.xpath(".//*[@id='closeBtn']")).click();
        //driver.findElement(By.xpath("//div[contains(@class, 'alert-wrapper')]//a[@id]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[@href='/menu/']/span")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[@href='/menu/desserts/']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[@href='/menu/desserts/cheesecakes/']")).click();

        List<WebElement> cheesecakes = driver.findElements(By.xpath("//a[contains(@href,'/menu/desserts/cheesecakes/')] /span[@class='item-title']"));

        System.out.println(cheesecakes.size() + "cheesecakes:");

        for (int i=0; i<cheesecakes.size(); i++) {

            System.out.println(i+1 + "." + cheesecakes.get(i).getText());
            if (cheesecakes.equals("HR")) return;

//for advancedSearchTest
//Assert.assertTrue(advancedSearchPage.getDescriptionStringList().get(0).contains("expectedContainedTerm"));// проверка первого элемента


            //for advancedSearch page
            /**
             * Creating a array massive which gets text from every found result in a page.
             * @return text from every found result in a page.
             */
           /* public List<String> getDescriptionStringList() {
                List<String> searchResultDescriptionsStringList = new ArrayList<String>();

                for (WebElement searchResultDescriptionsElement : searchResultDescriptionsList) {

                    searchResultDescriptionsStringList.add(searchResultDescriptionsElement.getText());
                }
                return searchResultDescriptionsStringList;
            }*/
        }

    }

}
