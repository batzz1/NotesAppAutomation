import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class BaseTest {


    protected static AppiumDriver driver;
    protected Properties properties;
    InputStream inputStream;



    @BeforeTest
    public void beforeTest() {
        try {
            properties = new Properties();
            String propertiesFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
            properties.load(inputStream);
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "11");
            desiredCapabilities.setCapability("deviceName", "Any");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, properties.getProperty("androidAutomationName"));
            desiredCapabilities.setCapability("appPackage", properties.getProperty("androidAppPackage"));
            desiredCapabilities.setCapability("appActivity", properties.getProperty("androidAppActivity"));
            String appPath = System.getProperty("user.dir") + File.separator + "app" + File.separator + properties.getProperty("androidAppName");
            desiredCapabilities.setCapability("app", appPath);
            // desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            URL url = new URL(properties.getProperty("appiumURL"));
            driver = new AndroidDriver(url, desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
