
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class baseClass {

    ElementsInPage elements;
    WebDriver driver;

    @BeforeTest
    public void initialize() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicesoftwaretesting.com/"); //

    }


    @AfterTest
    public void teadDown() {
        driver.quit();

    }
}