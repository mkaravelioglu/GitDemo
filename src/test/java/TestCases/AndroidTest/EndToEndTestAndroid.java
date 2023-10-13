package TestCases.AndroidTest;
import TestUtils.AndroidBaseTest;
import org.mustafakara.pageObjects.android.CartPage;
import org.mustafakara.pageObjects.android.ProductCatalogue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class EndToEndTestAndroid extends AndroidBaseTest {
    @BeforeMethod(alwaysRun = true)
    public void preSetup(){
        //screen to homepage
        formPage.setActivity();
    }
    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void EndToEnd(HashMap<String,String> input) throws InterruptedException {

        formPage.setCountry(input.get("country"));
        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));

        ProductCatalogue productCatalogue = formPage.submitForm();


        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(1);

        CartPage cartPage = productCatalogue.goToCartPage();


      /*  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(driver.findElement
                (By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        double totalSum = cartPage.getProductsSum();
        double displayedTotal = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum, displayedTotal);
        cartPage.acceptTermsConditions();
        cartPage.submitOrder();

        Thread.sleep(6000);

        //WebBrowser
        //A set of context handles which can be used to iterate over available contexts.
        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts){
            System.out.println(contextName);
        }
        //Switch app to browser
        driver.context("WEBVIEW_com.androidsample.generalstore");

        driver.findElement(By.name("q")).sendKeys("dolar/tl");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(6000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //Switch browser to App
        driver.context("NATIVE_APP");
    */}
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData
                (System.getProperty("user.dir") + "/src/test/java/testData/eCommerce.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

}


