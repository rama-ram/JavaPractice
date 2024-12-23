import org.example.FlightRoute;
import org.example.FlightRouteDataIterator;
import org.example.WebDriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderTest {
    WebDriver driver;
    @BeforeTest
    public void init(){
        driver= WebDriverBase.driver;
    }
    @DataProvider(name="flightData")
    public Iterator<FlightRoute[]> createFlightData() {
        return new FlightRouteDataIterator();

    }


    @Test(description = "to test data provider of testng", dataProvider = "flightData")
    public void flightsSearchTest(FlightRoute[] iterator){
        FlightRoute flightRoute = iterator[0];
        System.out.println("data recevived"+flightRoute.src+flightRoute.dest+flightRoute.date);
        driver.get("https://www.redbus.com/");
        Wait<WebDriver>  wait = new WebDriverWait(driver , Duration.ofSeconds(2));
        wait.until(d-> driver.findElement(By.id("src")).isDisplayed());
        By chains = new ByAll(By.id("src"),By.id("dest"),By.id("onward_cal"));
        List<WebElement> listWebElements = driver.findElements(chains);
        listWebElements.get(0).sendKeys(flightRoute.src);
        listWebElements.get(1).sendKeys(flightRoute.dest);
        listWebElements.get(2).sendKeys(flightRoute.date);
        listWebElements.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'DayNavigator') and contains(text(),'December')]/../../span//span[contains(@class,'DayTiles') and contains(text(),'24')]"))).click();

//        wait.until(d-> driver.findElement(By.xpath("//td[contains(@class, 'current day')]/following-sibling::td[contains(text(), '25')]"))).isDisplayed();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(d-> driver.findElement(By.xpath("//div[contains(text(),'SEARCH')]")).isDisplayed());
        driver.findElement(By.xpath("//div[contains(text(),'SEARCH')]")).click();
        wait.until(d->driver.findElement(By.className("bus-item")).isDisplayed());
        }

    public void process(int i) {
        i = i + 2;
        System.out.println("I chaned the value of i to " + i);

    }

    public static void main(String[] args) {
        int i = 2;
        DataProviderTest a = new DataProviderTest();
        a.process(i);
        System.out.println("after test i" + i);
    }
}
