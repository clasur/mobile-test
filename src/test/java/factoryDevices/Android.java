package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevice {

    @Override
    public AppiumDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","1723133810HA07LC");
        capabilities.setCapability("platformVersion","11");
        //capabilities.setCapability("appPackage","com.google.android.calculator");
        //capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        //con AndroidDriver permite crear la ruta del Appium server con el que se va a conectar trabajamos con los datos que nos muestra el insoector"remote host,puerto,remote Path"
        AppiumDriver driver= null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //implicit
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(15)));
        return driver;
    }
}
