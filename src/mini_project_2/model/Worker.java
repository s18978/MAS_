package mini_project_2.model;
import mini_project_1.exception.ValidationException;

public class Worker {

    private String name;
    private String surname;
    private String phoneNumber;

    private Shop workingPlace;

    public Worker(String name, String surname, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
    }

    public Worker(String name, String surname, String phoneNumber, Shop workingPlace) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setWorkingPlace(workingPlace);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || "".equals(name.trim())) {
            throw new ValidationException("worker's name should not be empty");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null || "".equals(surname.trim())) {
            throw new ValidationException("worker's surname should not be empty");
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

    public Shop getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(Shop workingPlace) {
        if(this.workingPlace == workingPlace) {
            return;
        }
        if(this.workingPlace == null) {
            this.workingPlace = workingPlace;
            workingPlace.addWorker(this);
        } else if (workingPlace == null) {
            Shop s = this.workingPlace;
            this.workingPlace = null;
            s.removeWorker(this);
        }
        else {
        setWorkingPlace(null);
        setWorkingPlace(workingPlace);
        }
    }
}