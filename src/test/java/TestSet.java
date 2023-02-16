import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestSet extends BaseTest {
    private String login = "pomov70955@mirtox.com";
    private String password = "Pomov70955@mirtox.com";
    private Logger logger = LogManager.getLogger(TestSet.class);


    @Test
    public void Test1() {
        setUpHeadless();
        driver.get("https://duckduckgo.com");
        clearAndEnter(By.cssSelector("#search_form_input_homepage"), "ОТУС");
        driver.findElement(By.cssSelector("#search_button_homepage")).submit();
        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...", driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[2]/h2/a/span")).getText());
    }

    @Test
    public void Test2() {
        setUp();
        driver.manage().window().maximize();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.className("content-overlay")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector(".pp_pic_holder")).isDisplayed());
        if (driver != null)
            driver.close();
    }

    @Test
    public void Test3(){
        Logger log = LogManager.getLogger(LogTestClass.class);
        setUp();
        driver.manage().window().fullscreen();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.get("https://otus.ru");
        loginInOtus();
        log.info(driver.manage().getCookies());
        if (driver != null)
            driver.close();
    }

    private void loginInOtus() {
        driver.findElement(By.cssSelector(".header3__button-sign-in")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        clearAndEnter(By.cssSelector("form.new-log-reg__form > div:nth-child(3) > input:nth-child(1)"), login);
        clearAndEnter(By.cssSelector(".new-input_password"), password);
        driver.findElement(By.cssSelector("div.new-input-line_last:nth-child(5) > button:nth-child(1)")).submit();
    }

    private void clearAndEnter(By by, String text)    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}

