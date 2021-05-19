package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class DriverFactory {

    private static WebDriver driver;
    public static String browserName=Config.BROWSER;

    public DriverFactory(){
        this.driver=getDriver();
    }

    public static WebDriver createDriver() {
        DesiredCapabilities capabilities;
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-cache");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new FirefoxDriver();
        }else {
            System.out.println("UnIdentified browser found");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver () {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void closeDriver () {
        driver.close();
        driver.quit();
    }

}


