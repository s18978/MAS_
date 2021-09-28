package mini_project_3.model.inheritances.multi;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;

public abstract class Person {

    private String name;
    private String surname;
    private String phoneNumber;

    public Person(String name, String surname, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
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
}