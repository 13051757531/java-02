package www.woniu.gui.one;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AgileOneAdd {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla Firefox_53\\firefox.exe");
        // System.setProperty("webdriver.gcko.driver", "D:\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://localhost/Agileone/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAgileoneAdd() throws Exception {
        driver.get(baseUrl + "/Agileone/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        assertTrue(isElementPresent(By.linkText("※ 公告管理 ※")));
        driver.findElement(By.linkText("※ 需求提案 ※")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("headline")).clear();
        driver.findElement(By.id("headline")).sendKeys("wujianbo35");
        driver.findElement(By.cssSelector("img.ke-common-icon.ke-icon-source")).click();
        driver.findElement(By.cssSelector("textarea.ke-textarea")).clear();
        driver.findElement(By.cssSelector("textarea.ke-textarea")).sendKeys("wujianbo34");
        driver.findElement(By.id("add")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.id("msg")).getText().matches("^成功啦: 新增数据成功 -> 编号=.*"));
        driver.findElement(By.linkText("注销")).click();
    }

    @After
    public void tearDown() throws Exception {
        try {
            driver.quit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}