package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ScenarioOne extends AbstractPage {

    //finding elements on page
    @FindBy(xpath = "(//a[@title='Evening Dresses'])[2]")
    private Button clickEveningDress;

    @FindBy(xpath = "//span[text()='More']")
    private Button clickMore;

    @FindBy(xpath = "//td[text()='Compositions']/following-sibling::td")
    private HtmlElement compositionsValue;

    @FindBy(xpath = "//td[text()='Styles']/following-sibling::td")
    private HtmlElement stylesValue;

    @FindBy(xpath = "//td[text()='Properties']/following-sibling::td")
    private HtmlElement propertiesValue;

    //constructor
    public ScenarioOne(WebDriver driver) {
        super(driver);

    }

    //Methods for running in test class
    public void hoverDress(WebDriver driver) {
        WebElement hoverDress = driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverDress).perform();
    }

    public void clickEveningDress() {
        clickEveningDress.click();
    }

    public void hoverPrintedDress(WebDriver driver) {
        WebElement hoverDress = driver.findElement(By.xpath("//img[@alt='Printed Dress']"));
        Actions action = new Actions(driver);
        action.moveToElement(hoverDress).perform();
    }

    public void clickMore() {
        clickMore.click();
    }

    //3 methods below for get elements value from page
    public String getCompositionsText() {
        return compositionsValue.getText();
    }

    public String getStylesText() {
        return stylesValue.getText();
    }

    public String getPropertiesText() {
        return propertiesValue.getText();
    }

    //methods for wait before elements loads
    public void waitForHoverDressesLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("(//a[@title='Dresses'])[2]")));
    }

    public void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//h3[text()='Data sheet']")));
    }

    public void waitForMoreButtonLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOfElementLocated(By.xpath("//span[text()='More']")));
    }


}
