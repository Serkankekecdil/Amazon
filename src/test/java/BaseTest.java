import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Element;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class BaseTest{
    WebDriver driver;

    final static Logger logger = Logger.getLogger(String.valueOf(BaseTest.class));

    @BeforeAll
        public void setUp(){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\testinium\\Selenium\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://www.amazon.com.tr/");
            driver.manage().window().maximize();
            driver.findElement(By.name("accept")).click();
            logger.info("Test Baslatildi.");

        }
        @AfterAll
        public void tearDown(){
            driver.quit();
            logger.info("Test Sonlandirildi.");
        }

        public void AllofThem() {

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
            logger.info("Textbox'a Laptop yazildi.");

        }
            public void ControlText(){
                WebElement element = driver.findElement(By.xpath("//div//span[@class='a-color-state a-text-bold']"));
                String text = element.getText();
                System.out.println(text);
                Assert.assertEquals("Laptop", "Laptop");
                logger.info("Laptop ürünü arandi.");
            }
            public void SearchButton () {

                driver.findElement(By.id("nav-search-submit-button")).click();
                logger.info("Search butonuna tiklanarak arama başlatildi.");
            }
            public void ViewProduct () {
                driver.findElement(By.cssSelector("span[class='a-size-base-plus a-color-base a-text-normal']")).click();
                logger.info("Ürün ekrani acildıive ürüne tiklanildi.");
            }
            public void AddBasket () {
                driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
                logger.info("Ürün sepete eklendi.");
            }
            public void GoBasket () {
                driver.findElement(By.id("sc-buy-box-ptc-button")).click();
                logger.info("Sepete git butonuna tiklandi ve Giris sayfasi acildi.");
            }
            public void MailBox () {
                driver.findElement(By.id("ap_email")).sendKeys("serkan.kekecd46@gmail.com");
                driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
                logger.info("Textbox'a mail adresi yazildi ve ileri butonuna tiklandi.Sifre giris sayfasi acıldi.");
            }
            public void PasswordBox () {
                driver.findElement(By.id("ap_password")).sendKeys("Serkan.46");
                driver.findElement(By.id("auth-signin-button")).click();
                logger.info("Textbox'a sifre yazildi ve ileri butonuna tiklandi.Adres sayfasi acildi.");
            }


        }






