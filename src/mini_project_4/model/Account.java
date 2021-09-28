package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.util.HashSet;
import java.util.Set;

public class Account {

    private long id;
    private static final Set<Account> extent = new HashSet<>();

    private Worker worker;

    private Client client;

    public Account(long id) {
        setId(id);
        extent.add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id == 0) {
            throw new ValidationException("id cant be null");
        }
        if(extent.stream().anyMatch(a -> a.getId() == id)) {
            throw new ValidationException("id must be unique");
        }
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker w) {

        if (client != null) {
            throw new ValidationException("association already exists with client");
        }
        if (this.worker == w) {
                return;
        }
        if (this.worker == null) {
            this.worker = w;
            w.setAccount(this);
        }
        else if (w == null) {
            Worker tmp = this.worker;
            this.worker = null;
            tmp.setAccount(null);
        }
        else {
            setWorker(null);
            setWorker(w);
        }
    }
    public Client getClient() { //xor
        return client;
    }

    public void setClient(Client c) {

        if (worker != null) {
            throw new ValidationException("association already exists with worker");
        }

        if (this.client == c) {
            return;
        }
        if (this.client == null) {
            this.client = c;
            c.setAccount(this);
        }
        else if (c == null) {
            Client tmp = this.client;
            this.client = null;
            tmp.setAccount(null);
        }
        else {
            setClient(null);
            setClient(c);
        }
    }
}