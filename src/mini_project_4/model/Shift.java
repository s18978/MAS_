package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.util.*;

public class Shift {

    private String weekDay;

    private final Set<Worker> workers = new HashSet<>();

    private Worker manager;

    public Shift(String weekDay, Worker worker) {
        setWeekDay(weekDay);
        addWorker(worker);
        setManager(worker);
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        if (weekDay == null) {
            throw new ValidationException("week day cant be null");
        }
        this.weekDay = weekDay;
    }

    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(workers);
    }

    public void addWorker(Worker w) {
        if(w == null) {
            throw new ValidationException("worker can not be null");
        }
        if(this.workers.contains(w)) {
            return;
        }
        this.workers.add(w);
        w.setShift(this);
    }

    public void removeWorker(Worker w) {
        if(w == null) {
            throw new ValidationException("worker can't be empty");
        }
        if(!this.workers.contains(w)) {
            return;
        }
        if(this.workers.size() <= 1) {
            throw new ValidationException("can not delete last worker");
        }
        this.workers.remove(w);
        w.setShift(null);
    }

    public Worker getManager() {
        return manager;
    }

    public void setManager(Worker manager) {
        if (manager == null) {
            throw new ValidationException("manager cannot be null");
        }
        if(!workers.contains(manager)) {
            throw new ValidationException("no such worker in a team");
        }
        this.manager = manager;
    }
}