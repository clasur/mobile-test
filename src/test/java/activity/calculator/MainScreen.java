package activity.calculator;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button fiveButton= new Button(By.id("com.google.android.calculator:id/digit_5"));
    public Button threeButton= new Button(By.id("com.google.android.calculator:id/digit_3"));
    public Button equalButton= new Button(By.id("com.google.android.calculator:id/eq"));
    public Button addButton= new Button(By.id("com.google.android.calculator:id/op_add"));
    public Label resultLabel= new Label(By.id("com.google.android.calculator:id/result_final"));
}
