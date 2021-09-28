package mini_project_3.model.inheritances.multi_aspect;
import mini_project_3.exception.ValidationException;

public class Worker extends Person {

    private double salary;

    public Worker(String name, String surname, String phoneNumber, Status status, double salary) {
        super(name, surname, phoneNumber, status);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary == 0) {
            throw new ValidationException("salary can not be null");
        }
        this.salary = salary;
    }
}