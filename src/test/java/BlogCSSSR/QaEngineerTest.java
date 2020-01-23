package BlogCSSSR;
/**
 * Autor Morozova Zh.A.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;


public class QaEngineerTest extends WebDriverSettings {
    @Test(enabled = true)
    public void linkSoftScreenshoterTest() {
        LOGGER.log(Level.INFO, "\n");
        LOGGER.log(Level.INFO, "------Cтарт теста валидности сссылки \"Софт для быстрого создания скриншотов\"------");

        //Выбрать вкладку НАХОДИТЬ НЕСОВЕРШЕНСТВА
        String xpathFindPerfections = "//a[@href = \"#\" and text() = \"НАХОДИТЬ НЕСОВЕРШЕНСТВА\"]";
        WebElement findPerfections = driver.findElement(By.xpath(xpathFindPerfections));
        findPerfections.click();

        String xpathSoftScreenshoter = "//a[text() = \"Софт для быстрого создания скриншотов\"]";
        WebElement softScreenshoter = driver.findElement(By.xpath(xpathSoftScreenshoter));

        //Проверка, что ссылка открывается в новом окне
        String target = softScreenshoter.getAttribute("target");
        if (!target.equals("_blank")){
            LOGGER.log(Level.WARNING, "Ссылка открывается в том же окне, должна открываться в новом");
        }
        Assert.assertEquals(target, "_blank",
                "Ссылка открывается в том же окне, должна открываться в новом");

        //Проверка адреса ссылки Софт для быстрого создания скриншотов
        String refSoftScreenshoter = softScreenshoter.getAttribute("href");
        String refSoftScreenshoterExpected = "http://monosnap.com/";

        if (!refSoftScreenshoter.equals("refSoftScreenshoterExpected")){
            LOGGER.log(Level.WARNING, String.format("Ожидаемый адрес ссылки %s, фактический %s", refSoftScreenshoterExpected,
                    refSoftScreenshoter));
        }
        Assert.assertEquals(refSoftScreenshoter, refSoftScreenshoterExpected,
            String.format("Ожидаемый адрес ссылки %s, фактический %s", refSoftScreenshoterExpected, refSoftScreenshoter));
    }

    @Test(enabled = true)
    public void repeatClickTabTest() {
        LOGGER.log(Level.INFO, "\n");
        LOGGER.log(Level.INFO, "------Cтарт теста очистки блока после повторного выбора уже активной ссылки-------");

        //Выбрать вкладку повторно кликнуть по заголовку вкладки
        String xpathFindPerfections = "//a[@href = \"#\" and text() = \"СОПРОВОЖДАТЬ ПРОЕКТЫ\"]";
        WebElement findPerfections = driver.findElement(By.xpath(xpathFindPerfections));
        findPerfections.click();
        findPerfections.click();

        //Проверить, что атрибут style имеет значение display: block; - похоже, именно он отвечает за отображение данных
        String xpathInfoDetailsBlock = "//div[@class = \"info-details\"]";//относится только к первой вкладке
        WebElement infoDetailsBlock = driver.findElement(By.xpath(xpathInfoDetailsBlock));
        String styleInfoDetails = infoDetailsBlock.getAttribute("style");

        if(!styleInfoDetails.equals("display: block;")){
            LOGGER.log(Level.WARNING, "После повторного клика на заголовке вкладки блок данных пуст");
        }
        Assert.assertEquals(styleInfoDetails, "display: block;",
                "После повторного клика на заголовке вкладки блок данных пуст");
    }
}
