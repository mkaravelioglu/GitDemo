package org.mustafakara.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.mustafakara.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewsPage extends IOSActions {
    IOSDriver driver;
    public AlertViewsPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
    private WebElement textEntryMenu;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;
    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' And value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmMenuItem;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement submit;
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'A message'")
    private WebElement confirmMessage;



    public void fillTextLabel(String text){
        textEntryMenu.click();
        textBox.sendKeys(text);
        acceptPopUp.click();
    }
    public String getConfirmMessage(){
        confirmMenuItem.click();
        return confirmMessage.getText();
    }
    public void submit(){
        submit.click();
    }

}
