package valerie.TelegramBot.Youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrapperService {
    static String globalSubscribers;
    static String globalLastVideo;

    //we will now declare the WebDriver, as per Selenium documentation
    public static WebDriver driver = new FirefoxDriver();
    protected final static String URL = "https://www.youtube.com/channel/";

    public static void scrape(final String value)
    {
        driver.get(URL + value);
        //gets the details of the channel and the subscriber count
        final WebElement subscribers = driver.findElement(By.xpath("//*[@id=\"channel-header\"]"));

        //gets the details of the last video
        final WebElement lastVideo = driver.findElement(By.xpath("//*[@id=\"details\"]"));

        //assigning local variable value to global variable value
        globalSubscribers = subscribers.getText();
        globalLastVideo = lastVideo.getText();

        //print it all out on your machine, just to check
        System.out.println(globalSubscribers);
        System.out.println();
        System.out.println(globalLastVideo);
        System.out.println();

        driver.quit();
    }
}


