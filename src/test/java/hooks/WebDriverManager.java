package hooks;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;

/*
Not in USE. this class is to create a customized WebDriver and ask Selenide to use it.
 */
public class WebDriverManager {

    private WebDriver webDriver;

    public WebDriver getDriver() {
        return webDriver;
    }

    public WebDriver getWebDriver(){
        String currentWebDriver = System.getProperty("browser", "");
        switch(currentWebDriver) {
            case ("chrome"):
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case ("firefox"):
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("marionette", true);
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case ("chromeHeadless"):
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                ChromeOptions chromeHeadless = new ChromeOptions();
                chromeHeadless.setHeadless(true);
                webDriver = new ChromeDriver(chromeHeadless);
                break;
            case ("iexplorer"):
                System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                webDriver = new InternetExplorerDriver(ieOptions);
                break;
            case ("edge"):
                System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
                webDriver = new EdgeDriver();
                break;
            case ("opera"):
                System.setProperty("webdriver.opera.driver", "operadriver.exe");
                webDriver = new OperaDriver();
                break;
            default:
                System.getProperty("browser", "chrome");
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
        }
        /**
         * Using Selenide driver:
         *
         * WebDriverRunner.setWebDriver(webDriver);
         */
        WebDriverRunner.setWebDriver(webDriver);
        return webDriver;
    }

    public void closeSession(){
        getDriver().close();
        getDriver().quit();
    }
}