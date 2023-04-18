package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    // WebDriver wd;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public String getEmail() {
        return properties.getProperty("web.email");
    }

    public String getPassword() {
        return properties.getProperty("web.password");
    }

    EventFiringWebDriver wd;
    HelperUser user;

    Properties properties;

    public void init() throws IOException {
        String configuration = System.getProperty("configuration", "config");
     //   properties.load(new FileReader(new File("src/test/resources/config.properties")));
        properties.load(new FileReader(new File(String.format("src/test/resources/config.properties", configuration))));
        //  wd=new ChromeDriver();
        if (browser.equals((BrowserType.CHROME))) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Testing on Chrome Driver");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Testing on Firefox Driver");
        }
        wd.register(new MyListener());
        user = new HelperUser(wd);
        //  wd.navigate().to("https://telranedu.web.app/home");
        wd.navigate().to(properties.getProperty("web.baseURL"));
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void stop() {
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }
}
