import driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import page.SearchPage;
import properties.PropertiesUtill;

import java.io.IOException;

public class SearchTest {
    @org.testng.annotations.Test
    public void test() throws IOException {
        SearchPage page = new SearchPage();
        PropertiesUtill utill = new PropertiesUtill();
        page.search(utill.getSearchWord());
        page.switchToGridView();
        page.switchToListView();
        page.goToNarrowCategory();
        Assert.assertTrue(page.isKeyWordsSame());
    }

    @AfterMethod
    public void close(){
        DriverSingleton.quit();
    }
}
