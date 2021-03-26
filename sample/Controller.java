package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import sample.data.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView<Contact> listContacts;

    @FXML
    private GridPane mainGridPane;
    @FXML
    private ContactData contactData;

    public void initialize() {

        contactData = new ContactData();
        contactData.loadContacts();
        listContacts.setItems(contactData.getContacts());
        }

    @FXML
    public void editContact() {
        Contact contact = listContacts.getSelectionModel().getSelectedItem();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newContactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Could not load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().setContentText(contact.getFirstName());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController dialogController = fxmlLoader.getController();
            contactData.delContact(contact);
            contactData.addContact(dialogController.changeContact(contact));
            contactData.saveContacts();
            System.out.println(dialogController.changeContact(contact).toString());
        }
    }
    @FXML
    public void newDialogWindow() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainGridPane.getScene().getWindow());
        dialog.setTitle("Add the new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newContactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
            catch (IOException e) {
                System.out.println("Could not load the dialog");
                e.printStackTrace();
                return;
            }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController dialogController = fxmlLoader.getController();
            Contact newContact = dialogController.processResult();
            contactData.addContact(newContact);
            contactData.saveContacts();
        }
    }
    public void deleteContact() {
        Contact deleteContact = listContacts.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete Contact: " + deleteContact.getFirstName() + " " + deleteContact.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            contactData.delContact(deleteContact);
        }
    }
    public void exit() {
        Platform.exit();
    }
}
