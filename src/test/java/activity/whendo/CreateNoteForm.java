package activity.whendo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class CreateNoteForm {
    public TextBox titleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));

    public TextBox updateTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public Button deleteButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button sureButton = new Button(By.id("android:id/button1"));


}
