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
        createNewNote();
    }

    @Test
    public void verifyUpdateForm(){
        createNewNote();
        updateNoteForm();
    }

    @Test
    public void deleteItem(){
        createNewNote();
        updateNoteForm();
        deleteNote();

    }

    @AfterEach
    public void closeApp(){
            Session.getInstance().closeApp();
    }

    private void createNewNote(){
        mainScreen.addNoteButton.click();
        createNoteForm.titleTextBox.setText(title);
        createNoteForm.noteTextBox.setText(note);
        createNoteForm.saveButton.click();
        //Verificacion Assert
        Assertions.assertTrue(mainScreen.isNotDisplayed(title), "Error!! la nota no fue creada");
    }

    private void updateNoteForm(){
        updateNoteForm.updateTextBox.click();
        String textBefore = createNoteForm.titleTextBox.getText();
        createNoteForm.titleTextBox.setText(textBefore + title1);
        createNoteForm.saveButton.click();
        Assertions.assertTrue(mainScreen.isNotDisplayed(textBefore + title1),"Error!! no se actualizo");
    }
    private void deleteNote(){
        updateNoteForm.updateTextBox.click();
        String textBefore = createNoteForm.titleTextBox.getText();
        deleteNoteForm.deleteButton.click();
        deleteNoteForm.sureButton.click();
        Assertions.assertFalse(mainScreen.isNotDisplayed(textBefore),"Error! no se elimino el item");
    }

}
