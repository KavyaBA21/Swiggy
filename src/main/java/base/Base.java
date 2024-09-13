package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {

    public static WebDriver driver;

    public static void initializeBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("No browser found");
        }
    }

    public static void lauchUrl(String url){
        driver.get(url);
    }

    public static void toCloseBrowser(){
        driver.quit();
    }

    public static void windowMax(){
        driver.manage().window().maximize();
    }

    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
