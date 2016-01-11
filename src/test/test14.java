package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test14 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://cse.unl.edu/";
<<<<<<< HEAD
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
=======
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
>>>>>>> b11f1cbd1f66ff081fdd7eabac38f430c788dfa9
  }

  @Test
  public void testTemp() throws Exception {
driver.get("http://cse.unl.edu/~mouna/WebApps/AddressBook/addressbookv3.3.16/index.php");
<<<<<<< HEAD
    driver.findElement(By.linkText("home")).click();
    driver.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Mouna");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Hammoudi");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("dsadsads");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("1289939313");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("1112121212");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("2121122121");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("mouna@cse.unl.edu");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("mouna@cse.unl.edu");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("2");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("February");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1991");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("300 south 16th street");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("cse.unl.edu");
    driver.findElement(By.name("submit")).click();
=======
    driver.findElement(By.cssSelector("html > body > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table:nth-child(2) > tbody > tr:nth-child(1) > td:nth-child(7) > a > img")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("JamesEDIT");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("PittEDIT");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("44545 R street EDIT");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("454545455 8989");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("454554555 2398");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("455455555 32323");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("j.pitt@gmail.com EDIT");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("jamespitt@hotmail.com EDIT");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("EDIT");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("EDIT");
    driver.findElement(By.name("update")).click();
    
>>>>>>> b11f1cbd1f66ff081fdd7eabac38f430c788dfa9
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
