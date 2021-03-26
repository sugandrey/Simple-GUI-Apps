package sample;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private SimpleStringProperty firstName = new SimpleStringProperty(null);
    private SimpleStringProperty lastName = new SimpleStringProperty(null);
    private SimpleStringProperty phoneNumber = new SimpleStringProperty(null);
    private SimpleStringProperty notes = new SimpleStringProperty(null);

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.notes.set(notes);
    }

    public Contact() {
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    //    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern(" MMMM dd, yyyy");
//        String myDate = df.format(date);
//        this.date = date;
//        //return myDate;
//    }

    @Override
    public String toString() {
        return this.firstName+" "+this.lastName+" "+this.phoneNumber+" "+this.notes;
    }
}
