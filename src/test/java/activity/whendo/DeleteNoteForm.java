package activity.whendo;

import appiumControl.AppiumControl;
import appiumControl.Button;
import org.openqa.selenium.By;

public class DeleteNoteForm {
    public Button deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button sureButton = new Button(By.id("android:id/button1"));
}
