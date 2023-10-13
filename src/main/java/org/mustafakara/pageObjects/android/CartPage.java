package org.mustafakara.pageObjects.android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.mustafakara.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmountLabel;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement alertTitle;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement closeButton;

    public List<WebElement> getProductList(){
        return productList;
    }

    public double getProductsSum(){
        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++){
            totalSum +=getFormattedAmount(productList.get(i).getText());
        }
        return totalSum;
    }
    public double getTotalAmountDisplayed(){
        return getFormattedAmount(totalAmountLabel.getText());
    }
    public void acceptTermsConditions(){
        longPressAction(termsButton);
        closeButton.click();
    }
    public void submitOrder(){
        checkBox.click();
        proceedButton.click();
    }



}
