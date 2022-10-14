package activity.whendo;

import appiumControl.Button;
import appiumControl.Label;
import com.sun.tools.javac.Main;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addNoteButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public MainScreen(){}

    public boolean isNotDisplayed(String title){
        Label note= new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        return  note.isControlDisplayed(); // es para ver si es mostrado o no el dato dinamico "XPath"
    }
}

