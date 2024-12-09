package BASE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest

    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
    }

    @AfterTest

    public void tearDown () throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}
