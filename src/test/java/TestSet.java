import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSet extends BaseTest {
    private String login = "pomov70955@mirtox.com";
    private String password = "Pomov70955@mirtox.com";
    private Logger logger = LogManager.getLogger(TestSet.class);


    @Test
    public void test1() {
        setUpHeadless();
        driver.get("https://duckduckgo.com");
        clearAndEnter(By.cssSelector("#search_form_input_homepage"), "ОТУС");
        driver.findElement(By.cssSelector("#search_button_homepage")).submit();
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...", driver.findElement(By.cssSelector("#r1-0 > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1) > span:nth-child(1)")).getText());
    }

    @Test
    public void test2() {
        setUp();
        driver.manage().window().maximize();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        WebDriverWait firstClick = new WebDriverWait(driver, Duration.ofSeconds(10));
        firstClick.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(1) > span > a > div.content-overlay")));
        driver.findElement(By.className("content-overlay")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".pp_pic_holder")).isDisplayed());
        if (driver != null)
            driver.close();
    }

    @Test
    public void test3(){
        Logger log = LogManager.getLogger(LogTestClass.class);
        setUpFullScreen();
        driver.get("https://otus.ru");
        loginInOtus();
        log.info(driver.manage().getCookies());
        if (driver != null)
            driver.close();
    }

    private void loginInOtus() {
        WebDriverWait firstClick = new WebDriverWait(driver, Duration.ofSeconds(10));
        firstClick.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header3__button-sign-in")));
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();
        WebDriverWait secondClick = new WebDriverWait(driver, Duration.ofSeconds(10));
        secondClick.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form.new-log-reg__form > div:nth-child(3) > input:nth-child(1)")));
        clearAndEnter(By.cssSelector("form.new-log-reg__form > div:nth-child(3) > input:nth-child(1)"), login);
        clearAndEnter(By.cssSelector(".new-input_password"), password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
    }

    private void clearAndEnter(By by, String text)    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}

