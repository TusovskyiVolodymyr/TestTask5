import driver.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import page.PaginationPage;

public class PaginationTest {
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        PaginationPage page = new PaginationPage();
        page.clickOnSortLink();
        page.clickOnPagination();
        Assert.assertTrue(page.isOptionVisible());
    }

    @AfterMethod
    public void close(){
        DriverSingleton.quit();
    }
}
