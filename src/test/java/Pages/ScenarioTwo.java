package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;

public class ScenarioTwo extends AbstractPage {

    //find elements on page
    @FindBy(tagName = "select")
    private Button clickSize;

    @FindBy(name = "Pink")
    private Button clickColor;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private Button clickAddToCart;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private Button clickContinueShopping;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private HtmlElement cartText;

    //Constructor
    public ScenarioTwo(WebDriver driver) {
        super(driver);
    }

    //method for using element
    public void clickSizeButton() {
        clickSize.click();
    }

    //method to open select and choose option
    public void clickToSelectSize(WebDriver driver) {
        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByVisibleText("M");
    }

    public void clickColorButton() {
        clickColor.click();
    }

    public void clickAddToCart() {
        clickAddToCart.click();
    }

    //method for click on button in popup-window and also wait for element load
    public void clickContinueShopping(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']")));
        clickContinueShopping.click();
    }

    //Method to get value from element
    public String getCartText() {
        return cartText.getText();
    }

    //two methods below to wait until elements load
    public void waitForDraftLoaded(String draftValue, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(attributeContains(By.xpath("//span[contains(@class,'mail-MessageSnippet-Item mail-MessageSnippet-Item_firstline')]//span"), "title", draftValue));
    }

    public void waitUntilPopupClosed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[@class='clearfix'])[1]")));
    }

}
