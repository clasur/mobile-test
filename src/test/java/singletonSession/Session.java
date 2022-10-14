package singletonSession;

import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Session {

//tener un atributo del mismo tipo
    private static Session session= null;
    private AppiumDriver driver;

//tener un constructor privado
    private Session(){
        //colocar la logica que necesitemos
        driver= FactoryDevice.make("android").create();
    }
    //tener un metodo statico publico para acceder a la instancia unica
    public static Session getInstance(){
        if(session == null)
            session= new Session();
        return session;

    }
    public  void closeApp(){
        driver.quit();
        session= null;
    }

    public AppiumDriver getDriver(){
        return driver;
    }
}
