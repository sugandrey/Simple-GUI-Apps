package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;

    @FXML
    public Contact processResult() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String notes = notesField.getText();
        return new Contact(firstName, lastName, phoneNumber, notes);
    }
@FXML
    public Contact changeContact(Contact contact) {
        contact.setFirstName(firstNameField.getText());
        contact.setLastName(lastNameField.getText());
        contact.setPhoneNumber(phoneNumberField.getText());
        contact.setNotes(notesField.getText());
        return contact;
    }
}
