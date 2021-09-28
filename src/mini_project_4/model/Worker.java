package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Worker {

    private String name;
    private String surname;
    private String phoneNumber;

    private final Set<Contract> contracts = new HashSet<>();

    private Account account;

    private Shift shift;

    private Cabinet cabinet;

    public Worker(String name, String surname, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new ValidationException("name should not be empty");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || "".equals(surname.trim())) {
            throw new ValidationException("surname should not be empty");
        }
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || "".equals(phoneNumber.trim())) {
            throw new ValidationException("phone number should not be empty");
        }
        if (!phoneNumber.matches("^(\\+\\d{1,2})?\\d{9}$")) {
            throw new ValidationException("phone number is not in right format");
        }
        this.phoneNumber = phoneNumber;
    }

    public Set<Contract> getContracts() {
        return Collections.unmodifiableSet(contracts);
    }

    public void addContract(Contract c) {
        if (c == null) {
            throw new ValidationException("contract can not be null");
        }
        if (c.getWorker() != this) {
            throw new ValidationException("contract isn't connected with this worker");
        }
        this.contracts.add(c);
    }

    public void removeContract(Contract c) {
        if (c == null) {
            throw new ValidationException("contract can not be null");
        }
        this.contracts.remove(c);
        if (c.getWorker() == this) {
            c.delete();
        }
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        if (this.account == account) {
            return;
        }
        if (this.account == null) {
            this.account = account;
            account.setWorker(this);
        }
        else if (account == null) {
            Account tmp = this.account;
            this.account = null;
            tmp.setClient(null);
        }
        else {
            setAccount(null);
            setAccount(account);
        }
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        if (shift == null) {
            throw new ValidationException("shift should not be null");
        }
        if (this.shift == shift) {
            return;
        }
        if (this.shift == null) {
            this.shift = shift;
            shift.addWorker(this);
        } else if (shift == null) {
            Shift tmp = this.shift;
            this.shift = null;
            tmp.addWorker(null);
        } else {
            setAccount(null);
            setAccount(account);
        }
    }
    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        if (this.cabinet == cabinet) {
            return;
        }
        Cabinet tmp = this.cabinet;
        try {
        if (this.cabinet == null) {
            this.cabinet = cabinet;
            cabinet.setWorker(this);
        } else if (cabinet == null) {
            this.cabinet = null;
            tmp.setWorker(null);
        } else {
            setCabinet(null);
            setCabinet(cabinet);
        } }catch (ValidationException v) {
            this.cabinet = tmp;
        }
    }
}