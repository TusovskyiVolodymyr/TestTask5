package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {
  private   WebDriver driver = DriverSingleton.getWebDriver();

    @FindBy(xpath = "//*[@id=\"mn_h\"]/div[3]/div/div[2]/div[1]/div[2]/div/div[1]/button[2]")
  private   WebElement rigthArrow;

    @FindBy(xpath = "//*[@id=\"mn_sec10174_pos\"]")
   private WebElement image;

    @FindBy(xpath = "//*[@id=\"mn_h\"]/div[3]/div/div[2]/div[1]/div[2]/div/a")
   private WebElement pause;

    @FindBy(xpath = "//*[@id=\"mn_sec10174_pos\"]/div[1]/div/div/span")
    private WebElement header;

    private Actions actions = new Actions(driver);

    public MainPage() {
        driver.get("https://marketplace.plenti.com/h____.htm");
        PageFactory.initElements(driver,this);
    }

    public void clickOnArrow() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(image).perform();
        rigthArrow.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void pauseResumeAutoScroll(){
        pause.click();
    }

    public boolean isHeaderPresent(){
      return   header.isDisplayed();
    }
    public void clickOnImage(){
        image.click();
    }
}
