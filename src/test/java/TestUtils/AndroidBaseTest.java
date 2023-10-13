package TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.mustafakara.pageObjects.android.FormPage;
import org.mustafakara.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AndroidDriver driver;
    private AppiumDriverLocalService service;
    public FormPage formPage;

    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/java/org/mustafakara/resources/data.properties");
        properties.load(fileInputStream);
        String ipAddress = System.getProperty("ipAddress") != null ?
                System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("AndroidDeviceName"));
        //options.setChromedriverExecutable();
        //options.setApp(System.getProperty("user.dir") + "/src/test/java/resources/ApiDemos-debug.apk");
        options.setApp(System.getProperty("user.dir") + "/src/test/java/resources/General-Store.apk");

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        formPage = new FormPage(driver);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
