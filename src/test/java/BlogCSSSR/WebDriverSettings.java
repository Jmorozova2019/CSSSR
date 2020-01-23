package BlogCSSSR;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WebDriverSettings {
    public static String URL_CSSSR = "https://blog.csssr.ru/qa-engineer/";
    public ChromeDriver driver;

    @BeforeClass
    public void setUp() {
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
