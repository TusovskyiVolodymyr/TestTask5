import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import page.MainPage;

public class WetherTest {
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        MainPage page = new MainPage();
        for (int i = 0; i <3 ; i++) {
            page.clickOnArrow();
        }
        page.pauseResumeAutoScroll();
        Thread.sleep(1000);
        page.pauseResumeAutoScroll();
//        Assert.assertTrue(page.isHeaderPresent());//доробити
//        page.clickOnImage();//доробити
    }

    @AfterMethod
    public void close(){
        DriverSingleton.quit();
    }


}
