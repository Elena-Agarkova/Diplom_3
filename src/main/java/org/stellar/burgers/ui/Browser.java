package org.stellar.burgers.ui;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Browser {

    // Выбор браузера
    public final static String BROWSER = "Yandex"; // "Yandex" or "Chrome"

    public static void browserChoice() {
        if (BROWSER.equals("Yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
            Configuration.browserBinary = "Applications/Yandex.app";
            WebDriver yandexDriver = new ChromeDriver();
            WebDriverRunner.setWebDriver(yandexDriver);


            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
        }
    }

    public static void closeNotChromeBrowser() {
        if (!BROWSER.equals("Chrome")) closeWebDriver();
    }
}