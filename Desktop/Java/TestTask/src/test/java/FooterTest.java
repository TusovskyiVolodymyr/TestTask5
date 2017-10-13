import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import page.FooterPAge;

public class FooterTest {
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        FooterPAge page = new FooterPAge();
        page.clickAndBack();
    }
    @AfterMethod
    public void close(){
        DriverSingleton.quit();
    }
}
