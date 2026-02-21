package net.xonich.serialization.data;

public class TextData {

    private String firstName;
    private String lastName;

    public TextData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TextData() {
        this("", "");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
