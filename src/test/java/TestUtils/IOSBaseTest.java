package TestUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.mustafakara.pageObjects.ios.HomePage;
import org.mustafakara.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {
    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage home;
    @BeforeClass
    public void ConfigureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/java/org/mustafakara/resources/data.properties");
        properties.load(fileInputStream);
        String ipAddress = System.getProperty("ipAddress") != null ?
                System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        //String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(properties.getProperty("IOSDeviceName"));
        options.setApp(System.getProperty("user.dir") + "/src/test/java/resources/UIKitCatalog.app");

/*
        options.setApp(System.getProperty("user.dir") + "/src/main/resources/TestApp 3.app");
*/
        options.setPlatformVersion("16.4");
        //Appium - Webdriver Agent -> IOS Apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(50));

        driver = new IOSDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        home = new HomePage(driver);

    }
    @AfterClass
    public void TearDown(){
        driver.quit();
        service.stop();
    }
}
