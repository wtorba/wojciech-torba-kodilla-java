package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");
        WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[text()=\'Akceptuj wszystkie\']"));
        acceptCookiesButton.click();
        WebElement createNewAccountButton = driver.findElement(By.xpath("//div[@class=\'_6ltg\']/a"));
        createNewAccountButton.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //while (!driver.findElement(By.xpath("//input[@name=\"firstname\"]")).isDisplayed());
        while(!driver.findElement(By.name(("firstname"))).isDisplayed());
        driver.findElement(By.name(("firstname"))).sendKeys("Johnny");
        driver.findElement(By.name("lastname")).sendKeys("Bravo");
        driver.findElement(By.name("reg_email__")).sendKeys("johny.bravo@cartoon.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Password");
        Select birthDay = new Select(driver.findElement(By.name("birthday_day")));
        birthDay.selectByValue("13");
        Select birthMonth = new Select(driver.findElement(By.name("birthday_month")));
        birthMonth.selectByValue("4");
        Select birthYear = new Select(driver.findElement(By.name("birthday_year")));
        birthYear.selectByValue("1970");
        driver.findElement(By.xpath("//input[@name=\"sex\" and @value=\"2\"]")).click();
    }
}
