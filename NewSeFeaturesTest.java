import org.example.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewSeFeaturesTest {
    private static WebDriver driver;

    @BeforeTest
    public void init(){
         driver = WebDriverBase.driver;
    }

    @Test
    public void LocatorChainingTest(){
        driver.get("https://www.redbus.com/");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(p-> driver.findElement(By.id("src")).isDisplayed());
        By chains = new ByAll(By.id("date-box"), By.id("dest"),By.id("src"));
        driver.findElement(By.id("src")).sendKeys("Mumbai");


//        By chaining= new ByChained(By.id(""),By.id(""));
//        driver.findElement(chaining.findElement())
    }
}
