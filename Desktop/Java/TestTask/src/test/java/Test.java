import driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import page.AllStoresPage;
import properties.PropertiesUtill;

import java.io.IOException;

public class Test {
    @BeforeTest
    public void init() throws IOException {
        PropertiesUtill utill = new PropertiesUtill();
    }

    @org.testng.annotations.Test
    public void test() throws InterruptedException, IOException {
        AllStoresPage page = new AllStoresPage();
        PropertiesUtill utill = new PropertiesUtill();
        page.verifySearch(utill.getQuickSearchKeyWord());
        for (int i = 0; i <page.click().size() ; i++) {
            Assert.assertTrue(page.click().get(i).toLowerCase().contains(utill.getQuickSearchKeyWord()));
        }
    }

    @AfterMethod
    public void close(){
        DriverSingleton.quit();
    }

}
