package mini_project_4.model;
import mini_project_4.exception.ValidationException;

public class Cabinet {

    private int number;

    private final double salaryForCabinet = 5000;

    private Worker worker;

    public Cabinet(int number) {
        setNumber(number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number == 0) {
            throw new ValidationException("number cant be null");
        }
        this.number = number;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        if(this.worker == worker) {
            return;
        }
        if(worker != null) {
            if(worker.getContracts().stream().noneMatch(c -> c.getSalary() > salaryForCabinet)) {
                throw new ValidationException("worker does not have enough salary");
            }
        }
        if(this.worker == null) {
            this.worker = worker;
            worker.setCabinet(this);
        } else if (worker == null) {
            Worker tmp = this.worker;
            this.worker= null;
            tmp.setCabinet(null);
        }
        else {
            setWorker(null);
            setWorker(worker);
        }
    }
}