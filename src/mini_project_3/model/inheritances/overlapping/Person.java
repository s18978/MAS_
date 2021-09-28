package mini_project_3.model.inheritances.overlapping;
import mini_project_3.exception.ValidationException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class Person implements Client, Worker {

    private String name;
    private String surname;
    private String phoneNumber;

    private Boolean loyaltyCard;
    private Double salary;

    private EnumSet<PersonType> personTypes;

    //for client and worker
    public Person(String name, String surname, String phoneNumber, Boolean loyaltyCard, Double salary) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);

        addPersonTypes(PersonType.CLIENT);
        addPersonTypes(PersonType.WORKER);

        setLoyaltyCard(loyaltyCard);
        setSalary(salary);
    }
    //for client
    public Person(String name, String surname, String phoneNumber, Boolean loyaltyCard) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);

        addPersonTypes(PersonType.CLIENT);

        setLoyaltyCard(loyaltyCard);
    }
    //for worker
    public Person(String name, String surname, String phoneNumber, Double salary) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);

        addPersonTypes(PersonType.WORKER);

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
        if(isClient()) {
            return loyaltyCard;
        }
        throw new ValidationException("worker does not have a loyalty card");
    }

    @Override
    public void setLoyaltyCard(boolean loyaltyCard) {
        if(isClient()) {
            this.loyaltyCard = loyaltyCard;
            return;
        }
        throw new ValidationException("worker does not have a loyalty card");
    }

    @Override
    public double getSalary() {
        if(isWorker()) {
            return salary;
        }
        throw new ValidationException("client does not have a salary");
    }

    @Override
    public void setSalary(double salary) {
        if(isWorker()) {
            this.salary = salary;
            return;
        }
        throw new ValidationException("client does not have a salary");
    }

    public Set<PersonType> getPersonTypes() {
        return Collections.unmodifiableSet(personTypes);
    }

    private void addPersonTypes(PersonType personType) {
        if (personType == null) {
            throw new ValidationException("person types should not be null");
        }
        if(personTypes == null) {
            personTypes = EnumSet.of(personType);
            return;
        }
        personTypes.add(personType);

    }

    public boolean isClient() {
        return personTypes.contains(PersonType.CLIENT);
    }

    public boolean isWorker() {
        return personTypes.contains(PersonType.WORKER);
    }

}