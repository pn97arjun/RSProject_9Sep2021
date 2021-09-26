package com.brokenlink;
import java.io.IOException;
import java.net.URL;
import java.net.*;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

    private static WebDriver driver=null;
    public static void main(String[] args)
    {
        String url=" ";
        String homepage="https://www.zlti.com/";
        int responseCode=200;
        HttpURLConnection huc=null;

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homepage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> links=driver.findElements(By.tagName("a"));
        Iterator<WebElement> it=links.iterator();

        while (it.hasNext())
        {
            url=it.next().getAttribute("href");
            System.out.println(url);
            if(url==null || url.isEmpty())
                System.out.println("URL EMPTY");
            continue;
        }

        try
        {
           huc=(HttpURLConnection) (new URL(url).openConnection());
           huc.setRequestMethod("HEAD");
           huc.connect();
           responseCode=huc.getResponseCode();

           if(responseCode>=400)
           {

               System.out.println(url+" is a broken link");
           }
           else {

               System.out.println(url+" is valid link");
           }

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

      driver.quit();

    }
}
