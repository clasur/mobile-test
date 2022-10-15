package testMain;

import activity.whendo.CreateNoteForm;
import activity.whendo.DeleteNoteForm;
import activity.whendo.MainScreen;
import activity.whendo.UpdateNoteForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class WhenDoTest {
    MainScreen mainScreen= new MainScreen();
    CreateNoteForm createNoteForm = new CreateNoteForm();
    UpdateNoteForm updateNoteForm = new UpdateNoteForm();
    DeleteNoteForm deleteNoteForm = new DeleteNoteForm();
    String title = "University";
    String note = "This is a new note";
    String title1= ",now updated";

    @Test
    public void verifyCreateNewNote() {

        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();
        //Verificacion Assert
        Assertions.assertTrue(mainScreen.isNotDisplayed(title), "Error!! la nota no fue creada");
    }

    @Test
    public void verifyUpdateForm(){


        updateNoteForm.updateTextBox.click();
        String textBefore = createNoteForm.titleTextBox.getText();
        createNoteForm.titleTextBox.setText(textBefore + title1);
        createNoteForm.saveButton.click();
        Assertions.assertTrue(mainScreen.isNotDisplayed(textBefore + title1),"Error!! no se actualizo");
    }

    @Test
    public void deleteItem(){
        String textBefore = createNoteForm.titleTextBox.getText();
        updateNoteForm.updateTextBox.click();
        deleteNoteForm.deleteButton.click();
        deleteNoteForm.sureButton.click();
        Assertions.assertFalse(mainScreen.isNotDisplayed(textBefore),"Error! no se elimino el item");
    }

     @AfterEach
     public void closeApp(){
            Session.getInstance().closeApp();
        }
}
