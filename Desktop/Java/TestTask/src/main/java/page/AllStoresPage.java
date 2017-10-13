package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.PropertiesUtill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllStoresPage {
    private WebDriver driver = DriverSingleton.getWebDriver();

    Actions actions = new Actions(driver);

    WebDriverWait wait=new WebDriverWait(driver, 20);

    @FindBy(xpath = "//*[@id=\"mn_quickFindBox\"]")
   private   WebElement element;

    @FindAll(@FindBy(xpath = "//*[@id=\"mn_b\"]/div[3]/div/div[2]/div[3]/form/div/ul/li/a"))
    private List<WebElement> links;

    public AllStoresPage() throws IOException {
        driver.get("https://marketplace.plenti.com/b____.htm");
        PageFactory.initElements(driver,this);
    }

    public void verifySearch(String searchKey) throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(element).perform();
        if(element.isDisplayed()) {
            element.sendKeys(searchKey);
        }
        else {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mn_quickFindBox\"]")));
        }

    }
    public List<String> click(){
        List<String> results = new ArrayList<>();
        for (WebElement el:links) {
            results.add(el.getText());
        }
        return results;
    }

}

