package mini_project_3.model.inheritances.dynamic;
import mini_project_3.exception.ValidationException;

public class Person implements Client, Worker {

    private String name;
    private String surname;
    private String phoneNumber;

    private Boolean loyaltyCard;
    private Double salary;

    private PersonType personType;

    //for client
    public Person(String name, String surname, String phoneNumber, Boolean loyaltyCard) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setPersonType(PersonType.CLIENT);
        setLoyaltyCard(loyaltyCard);
    }

    //for worker
    public Person(String name, String surname, String phoneNumber, Double salary) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        setPersonType(PersonType.WORKER);
        setSalary(salary);
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

    @Override
    public boolean getLoyaltyCard() {
        if (isClient()) {
            return loyaltyCard;
        }
        throw new ValidationException("worker does not have a loyalty card");
    }

    @Override
    public void setLoyaltyCard(boolean loyaltyCard) {
        if (isClient()) {
            this.loyaltyCard = loyaltyCard;
            return;
        }
        throw new ValidationException("worker does not have a loyalty card");
    }

    @Override
    public double getSalary() {
        if (isWorker()) {
            return salary;
        }
        throw new ValidationException("client does not have a salary");
    }

    @Override
    public void setSalary(double salary) {
        if (isWorker()) {
            this.salary = salary;
            return;
        }
        throw new ValidationException("client does not have a salary");
    }

    public PersonType getPersonType() {
        return personType;
    }

    private void setPersonType(PersonType personType) {
        if (personType == null) {
            throw new ValidationException("person types should not be null");
        }
        this.personType = personType;
    }

    public boolean isClient() {
        return personType.equals(PersonType.CLIENT);
    }

    public boolean isWorker() {
        return personType.equals(PersonType.WORKER);
    }

    public void becomeClient(boolean loyaltyCard) {
        salary = null;
        personType = PersonType.CLIENT;
        setLoyaltyCard(loyaltyCard);
    }

    public void becomeWorker(double salary) {
        loyaltyCard = null;
        personType = PersonType.WORKER;
        setSalary(salary);
    }
}