package cleanTest;

import activity.calculator.MainScreen;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class CalculatorTest {
    MainScreen mainScreen= new MainScreen();

    @Test
    public void verifyAddCalculator(){
        mainScreen.fiveButton.click();
        mainScreen.addButton.click();
        mainScreen.threeButton.click();
        mainScreen.equalButton.click();
        String exp= "8";
        Assertions.assertEquals(exp,mainScreen.resultLabel.getText(),"ERROR!, la suma esta mal");

    }
    @AfterEach
    public void close(){
        Session.getInstance().closeApp();

    }
}
