package mini_project_3.model.inheritances.multi_aspect;
import mini_project_3.exception.ValidationException;

public class Person {

    private String name;
    private String surname;
    private String phoneNumber;

    private Status status;

    public Person(String name, String surname, String phoneNumber, Status status) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new ValidationException("name should not be null");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) {
            throw new ValidationException("surname should not be null");
        }
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new ValidationException("phone number should not be null");
        }
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    private void setStatus(Status status) {
        if (status == null) {
            throw new ValidationException("status should not be null");
        }
        this.status = status;
    }
}