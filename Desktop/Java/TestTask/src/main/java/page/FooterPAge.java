package page;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FooterPAge {
    private WebDriver driver = DriverSingleton.getWebDriver();

    private Actions actions = new Actions(driver);

    private WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindAll(@FindBy(xpath = "/html/body/footer/div/section[1]/div/nav[1]/ul/li/a"))
  private   List<WebElement> footerLinks;

    @FindBy(xpath = ".//div[@class=\"wrapper-content\"]")
    WebElement link;

    @FindBy(xpath = "/html/body/footer/div/section[1]/div/nav[1]/ul/li[1]/a")
    WebElement footerTitle;

    public FooterPAge() {
        driver.get("https://marketplace.plenti.com/h____.htm");
        PageFactory.initElements(driver,this);
    }

    public void clickAndBack() throws InterruptedException {
//        footerLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/footer/div/section[1]/div/nav[1]/ul/li/a")));
//        Coordinates coordinate = ((Locatable)footerTitle).getCoordinates();
//        coordinate.onPage();
//        coordinate.inViewPort();
        Thread.sleep(10000);
        actions.moveToElement(link).perform();
        System.out.println(footerLinks.size());
        for (WebElement el:footerLinks){
            el.click();
            driver.navigate().back();
            Thread.sleep(1500);
        }
    }
}
