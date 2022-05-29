package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class ScenarioThree extends AbstractPage {
    //find elements on page
    @FindBy(xpath = "//b[text()='Cart']")
    private Button hoverCart;

    @FindBy(css = "a#button_order_cart>span")
    private Button clickCheckOut;

    @FindBy(className = "icon-trash")
    private Button clickDelete;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private HtmlElement deleteMessage;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    private HtmlElement cartEmptyMessage;

    //constructor
    public ScenarioThree(WebDriver driver) {
        super(driver);
    }

    public void hoverCart() {
        hoverCart.click();
    }

    //methods to use in scenario
    public void clickCheckoutButton() {
        clickCheckOut.click();
    }

    public void clickDeleteButton() {
        clickDelete.click();
    }

    //2 methods below for get values of elements
    public String getDeleteMessage() {
        return deleteMessage.getText();
    }

    public String getCartEmptyMessage() {
        return cartEmptyMessage.getText();
    }

    public Boolean deleteMessagePresented() {
        return cartEmptyMessage.isDisplayed();
    }

    //method for wait element load
    public void waitUntilCartEmpty(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-warning")));
    }

}
