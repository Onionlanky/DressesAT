import Pages.ScenarioOne;
import Pages.ScenarioTwo;
import Pages.ScenarioThree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected static WebDriver driver = null;
    private ScenarioOne scenarioOne = null;
    private ScenarioTwo scenarioTwo = null;
    private ScenarioThree scenarioThree = null;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    //Actions before tests
    @BeforeAll
    public static void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //method for get page to load in scenario
    protected void openTestResource() {
        driver.get("http://automationpractice.com/index.php");
    }

    protected ScenarioOne onScenarioOnePage() {
        if (scenarioOne == null) {
            scenarioOne = new ScenarioOne(driver);
        }
        return scenarioOne;
    }

    protected ScenarioTwo onScenarioTwoPage() {
        if (scenarioTwo == null) {
            scenarioTwo = new ScenarioTwo(driver);
        }
        return scenarioTwo;
    }

    protected ScenarioThree onScenarioThreePage() {
        if (scenarioThree == null) {
            scenarioThree = new ScenarioThree(driver);
        }
        return scenarioThree;
    }

    //Actions after tests
    @AfterAll
    public static void shutDown() {
        driver.quit();
        driver = null;

    }
}
