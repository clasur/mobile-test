package cleanTest;

import activity.whendo.CreateNoteForm;
import activity.whendo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class CreateNoteWhenDoTest {
    MainScreen mainScreen= new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();

    @Test
    public void verifyCreateNewNote() {

        String title = "Cato";
        String note = "Esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();
        //Verificacion Assert
        Assertions.assertTrue(mainScreen.isNotDisplayed(title), "Error!! la nota no fue creada");

    }
    public void verifyUpdateNote() {

        String title = "Cato Update";
        String note = "Esta es una nota";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();
        //Verificacion Assert
        Assertions.assertTrue(mainScreen.isNotDisplayed(title), "Error!! la nota no fue creada");

    }
    public void verifyDeleteNote() {


        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.click();
        createNoteForm.saveButton.click();
        //Verificacion Assert
        Assertions.assertTrue(mainScreen.isNotDisplayed(title), "Error!! la nota no fue creada");

    }
     @AfterEach
     public void closeApp(){
            Session.getInstance().closeApp();
        }
}
