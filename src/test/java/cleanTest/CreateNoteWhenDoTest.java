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

    @Test
    public void verifyUpdateTitle(){
        String title1= "nueva";

        createNoteForm.updateTextBox.click();
        createNoteForm.titleTextBox.setText(title1);
        createNoteForm.saveButton.click();
        Assertions.assertTrue(mainScreen.isNotDisplayed(title1),"Error!! no se actualizo");
    }

    @Test
    public void deleteItem(){
        createNoteForm.updateTextBox.click();
        createNoteForm.deleteButton.click();
        createNoteForm.sureButton.click();
        Assertions.assertTrue(mainScreen.isNotDisplayed(""),"Error! no se elimino el item");
    }

     @AfterEach
     public void closeApp(){
            Session.getInstance().closeApp();
        }
}
