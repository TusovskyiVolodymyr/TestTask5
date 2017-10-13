package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.PropertiesUtill;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    private WebDriver driver = DriverSingleton.getWebDriver();

    private PropertiesUtill  utill =  new PropertiesUtill();

    @FindBy(xpath = "//*[@id=\"mn_bc\"]/div[2]/div/div/div[2]/div/form/input")
    private WebElement input;

    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[2]/div/div[1]/div/a[1]")
    private WebElement gridView;

    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[2]/div/div[1]/div/a[2]")
    private WebElement listView;

    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[1]/div[2]/aside/div[2]/div[1]/ul/li[1]/a")
    private WebElement narrowCategory;

    @FindBy(xpath = "//*[@id=\"mn_sr\"]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/strong")
   private WebElement keyWord;

    public SearchPage() throws IOException {
        driver.get("https://marketplace.plenti.com/Apparel-Babies-Kids/bc_1___.htm");
        PageFactory.initElements(driver,this);
    }

    public void search(String key){

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        input.sendKeys(key);
        input.submit();
    }

    public void switchToGridView(){
        gridView.click();
    }

    public void switchToListView(){
        listView.click();
    }

    public void goToNarrowCategory(){
        narrowCategory.click();
    }
    public boolean isKeyWordsSame(){
        return keyWord.getText().toLowerCase().contains(utill.getSearchWord());
    }



}
