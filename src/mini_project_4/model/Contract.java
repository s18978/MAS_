package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contract {

    private LocalDate employmentDate;

    private double salary;
    private final double minSalary = 3000;

    private static List<Contract> extent = new ArrayList<>();

    private Worker worker;
    private Shop shop;

    public Contract(LocalDate employmentDate, double salary, Worker worker, Shop shop) {
        setEmploymentDate(employmentDate);
        setSalary(salary);

        if(worker == null || shop == null) {
            throw new ValidationException("worker or shop cannot be null");
        }

        setWorker(worker);
        setShop(shop);
        extent.add(this);
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        if (employmentDate == null) {
            throw new ValidationException("date of employment can not be null");
        }
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= minSalary) {
            throw new ValidationException("salary should not be less than min salary");
        }
        this.salary = salary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public static List<Contract> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public Worker getWorker() {
        return worker;
    }

    public Shop getShop() {
        return shop;
    }

    private void setWorker(Worker worker) {
        Worker tmp = this.worker;
        this.worker = worker;
        if(worker == null && tmp != null) {
            tmp.removeContract(this);
        }

        if(worker != null) {
            worker.addContract(this);
        }
    }

    private void setShop(Shop shop) {
        Shop tmp = this.shop;
        this.shop = shop;
        if(tmp != null) {
            tmp.removeContract(this);
        }
        if(shop != null) {
            shop.addContract(this);
        }
    }
    public void delete() {
        if(this.worker != null) {
            setWorker(null);
        }
        if(this.shop != null) {
            setShop(null);
        }
        extent.remove(this);
    }
}