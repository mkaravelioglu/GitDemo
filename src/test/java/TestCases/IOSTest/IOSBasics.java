package TestCases.IOSTest;
import TestUtils.IOSBaseTest;
import org.mustafakara.pageObjects.ios.AlertViewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
    @Test
    public void IOSBasicsTest(){

        AlertViewsPage alertViews = home.selectAlertViews();
        alertViews.fillTextLabel("Hello World");
        String actualMessage = alertViews.getConfirmMessage();
        Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
        alertViews.submit();




    }

}
