package BlogCSSSR;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class WebDriverSettings {
    public static String URL_CSSSR = "https://blog.csssr.ru/qa-engineer/";
    public ChromeDriver driver;

    public static Logger LOGGER = Logger.getLogger(WebDriverSettings.class.getName());

    private void setUpLogger(){
        try {
            InputStream is = WebDriverSettings.class.getResourceAsStream("/logging.properties");
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }

    @BeforeClass
    public void setUp() {
        setUpLogger();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(URL_CSSSR);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Квест ассистента менеджера"),
                "Не удалось открыть нужную страницу или заголовок страницы был изменен");
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
