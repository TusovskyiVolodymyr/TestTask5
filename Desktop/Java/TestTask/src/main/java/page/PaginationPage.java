package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class PaginationPage {
   private WebDriver driver = DriverSingleton.getWebDriver();
   private WebDriverWait wait = new WebDriverWait(driver,10);
   private Actions actions = new Actions(driver);

    @FindBy(xpath = "//*[@id=\"mmt258_tabs\"]/li[2]/a")
    private WebElement sortingLink;

    @FindBy(xpath = "//*[@id=\"mn_sp\"]/div[3]/div/div[2]/div[3]/div[2]/div[4]/div[2]/div/label/select")
    WebElement pagination;

    @FindBy(xpath = "//*[@id=\"mn_sp\"]/div[3]/div/div[2]/div[3]/div[2]/div[4]/div[2]/div/label/select")
    Select page;

    @FindBy(xpath = "//*[@id=\"mn_sp\"]/div[3]/div/div[2]/div[3]/div[2]/div[4]/div[2]/div/label/select/option")
    java.util.List<WebElement> options;

    public PaginationPage() {
        driver.get("https://marketplace.plenti.com/sp____.htm");
        PageFactory.initElements(driver,this);
    }

    public void clickOnSortLink(){
        sortingLink.click();
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

    }

    public void clickOnPagination() throws InterruptedException {
         Select select = new Select(pagination);
        pagination = wait.until(ExpectedConditions.elementToBeClickable(pagination));
        actions.moveToElement(pagination).perform();
        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByIndex(0);

    }

    public boolean isOptionVisible(){
        return options.get(0).isDisplayed();
    }
}
