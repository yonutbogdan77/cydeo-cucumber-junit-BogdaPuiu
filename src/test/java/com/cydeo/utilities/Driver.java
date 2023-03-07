package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    /*
      Creating a private constructor, so we are closing access to
      the object of this class from outside the class
       */
    private Driver() {

    }

    /*
    We make WebDriver private, because we want to close access from outside the class
    We make it static because we will use it in a static method
     */
    //private static WebDriver driver;
    private  static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

    /*
    Create a reusable utility method wich will return same driver when we call it
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            //We read our driver from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");


            switch (browserType) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "100.25.34.226";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to create remote session!!!");
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }

    //This method will make sure our driver value is always null after using quit() method
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();// this line will terminate the existing session. Value will not even be null
            driverPool.remove();
        }

    }
}
