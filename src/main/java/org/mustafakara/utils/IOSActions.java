package org.mustafakara.utils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.util.HashMap;
import java.util.Map;

public class IOSActions extends AppiumUtils{
    IOSDriver driver;

    public IOSActions(IOSDriver driver){
        this.driver = driver;
    }
    public void longPressAction(WebElement ele, int duration){
        Map<String,Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration", duration);
        driver.executeScript("mobile:touchAndHold", params);
    }

    public void scrollToWebElement(WebElement ele, String direction){
        Map<String,Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll", params);
    }
    public void SliderTest(WebElement ele, int i){
        ele.sendKeys(i+"%");
    }

    public void swipe(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("direction", "left");
        driver.executeScript("mobile:swipe", params);
    }
}
