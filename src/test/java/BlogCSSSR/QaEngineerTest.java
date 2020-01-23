package BlogCSSSR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class QaEngineerTest extends WebDriverSettings {
    @Test
    public void linkSoftScreenshoterTest() {
        //Выбрать вкладку НАХОДИТЬ НЕСОВЕРШЕНСТВА
        String xpathFindPerfections = "//a[@href = \"#\" and text() = \"НАХОДИТЬ НЕСОВЕРШЕНСТВА\"]";
        WebElement findPerfections = driver.findElement(By.xpath(xpathFindPerfections));
        findPerfections.click();

        String xpathSoftScreenshoter = "//a[text() = \"Софт для быстрого создания скриншотов\"]";
        WebElement softScreenshoter = driver.findElement(By.xpath(xpathSoftScreenshoter));

        //Проверка, что ссылка открывается в новом окне
        String target = softScreenshoter.getAttribute("target");
        Assert.assertTrue(target.equals("_blank"), "Ссылка открывается в том же окне");

        //Проверка адреса ссылки Софт для быстрого создания скриншотов
        String refSoftScreenshoter = softScreenshoter.getAttribute("href");
        String refSoftScreenshoterExpected = "http://monosnap.com/";
        Assert.assertTrue(refSoftScreenshoter.equals(refSoftScreenshoterExpected),
                String.format("Ожидаемый адрес ссылки %s, фактический %s", refSoftScreenshoterExpected, refSoftScreenshoter));
    }

    @Test
    public void repeatClickTabTest() {
        //Выбрать вкладку повторно кликнуть по заголовку вкладки
        String xpathFindPerfections = "//a[@href = \"#\" and text() = \"СОПРОВОЖДАТЬ ПРОЕКТЫ\"]";
        WebElement findPerfections = driver.findElement(By.xpath(xpathFindPerfections));
        findPerfections.click();
        findPerfections.click();

        //Проверить, что атрибут style имеет значение display: block; - похоже, именно он отвечает за отображение данных
        String xpathInfoDetailsBlock = "//div[@class = \"info-details\"]";//относится только к первой вкладке
        WebElement infoDetailsBlock = driver.findElement(By.xpath(xpathInfoDetailsBlock));
        String styleInfoDetails = infoDetailsBlock.getAttribute("style");
        Assert.assertTrue(styleInfoDetails.equals("display: block;"), "После повторного клика блок данных пуст");
        }
}
