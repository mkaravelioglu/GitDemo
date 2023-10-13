package org.mustafakara.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.build.AndroidDescriptor;
import org.mustafakara.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    AndroidDriver driver;
    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @FindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private List<WebElement> addToCart;

    @FindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;


    public void addItemToCartByIndex(int index){
        addToCart.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cartButton.click();
        Thread.sleep(2000);
        return new CartPage(driver);

    }


}
