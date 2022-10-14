package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.time.Duration;

public class BasicAppium {
    private AppiumDriver driver; //conexion con  appium

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","1723133810HA07LC");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("platformName","Android");
   //con AndroidDriver permite crear la ruta del Appium server con el que se va a conectar trabajamos con los datos que nos muestra el insoector"remote host,puerto,remote Path"
        driver= new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"),capabilities);
        //implicit
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(15)));
    }

    @Test
    public void verifyCalculator() throws InterruptedException{ // para hacer acciones
        //Sumar 5+3=8
        //click button 5
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        //click button +
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        //click button 3
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        //click button =
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        //varification expected vs actual
        String expectedResult= "8";
        String actualResult= driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR!! La suma esta errada");

    Thread.sleep(5000);

    }

    @AfterEach
    public void cleanup(){
        driver.quit();

    }

}
