import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Project2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Petar\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.strela.co.rs/");
        driver.manage().window().maximize();

        WebElement store = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span"));
        store.click();

        WebElement bows = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div"));
        bows.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions scrollDown = new Actions(driver);
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement samickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samickSage.click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"), "Bow Samick Sage"));

        WebElement hederTitle = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));

        String expectedTitle = "Samick";
        String actualTitle = hederTitle.getText();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }
}


