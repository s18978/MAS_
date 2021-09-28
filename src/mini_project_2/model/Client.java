package mini_project_2.model;
import mini_project_1.exception.ValidationException;

public class Client {

    private String name;
    private String surname;
    private String phoneNumber;

    private FirstPurchase firstPurchase;

    public Client(String name, String surname, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
    }

    public Client(String name, String surname, String phoneNumber, FirstPurchase firstPurchase) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setFirstPurchase(firstPurchase);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || "".equals(name.trim())) {
            throw new ValidationException("name should not be empty");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null || "".equals(surname.trim())) {
            throw new ValidationException("surname should not be empty");
        }
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null || "".equals(phoneNumber.trim())) {
            throw new ValidationException("phone number should not be empty");
        }
        if(!phoneNumber.matches("^(\\+\\d{1,2})?\\d{9}$")) {
            throw new ValidationException("phone number is not in right format");
        }
        this.phoneNumber = phoneNumber;
    }

    public FirstPurchase getFirstPurchase() {
        return firstPurchase;
    }

    public void setFirstPurchase(FirstPurchase firstPurchase) {
        if(firstPurchase == null) {
            if(this.firstPurchase != null && this.firstPurchase.getClient() == null) {
                this.firstPurchase = null;
            }
            if(this.firstPurchase != null) {
                this.firstPurchase.delete();
            }
        } else {
            if(firstPurchase.getClient() != this) {
                throw new ValidationException("this client is not assigned to the first purchase");
            }
            if(this.firstPurchase != null) {
                this.firstPurchase.delete();
            }
            this.firstPurchase = firstPurchase;
        }
    }
}