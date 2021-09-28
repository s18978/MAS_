package mini_project_3.model.inheritances.multi;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;

public class Worker extends Person {

    private double salary;

    public Worker(String name, String surname, String phoneNumber, double salary) {
        super(name, surname, phoneNumber);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary == 0) {
            throw new ValidationException("salary should not be null");
        }
        this.salary = salary;
    }
}