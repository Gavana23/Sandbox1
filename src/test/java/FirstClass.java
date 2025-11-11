
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass {
    //открыть браузер
    //зайти на сайт

    @Test
    public void zipCode() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("123456");
        browser.findElement(By.xpath("//input[@value = 'Continue']")).click();
        Thread.sleep(1000);
        boolean registerButton = browser.findElement(By.xpath("//input[@value = 'Register']")).isDisplayed();

        assertTrue(registerButton, "Ожидалось наличие кнопки 'Register");

        //browser.quit();
    }

    @Test
    public void zipDigitCode() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name = 'zip_code']")).sendKeys("1");
        browser.findElement(By.xpath("//input[@value = 'Continue']")).click();
        Thread.sleep(1000);
        String errorText = browser.findElement(By.cssSelector(".error_message")).getText();

        assertEquals(errorText, "Oops, error on page. ZIP code should have 5 digits");

        //browser.quit();
    }
}
