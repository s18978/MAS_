package mini_project_3.model.inheritances.multi;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class multiTest {

    @Test
    public void test() {

        List<Client> clientsList = new ArrayList<>();
        List<Worker> workersList = new ArrayList<>();

        Client c1 = new ClientImpl("name1", "surname1", "phoneNum1", true);
        clientsList.add(c1);
        Client c2 = new ClientImpl("name2", "surname2", "phoneNum2", true);
        clientsList.add(c2);

        Worker w1 = new Worker("name1", "surname1", "phoneNum1", 500.1);
        workersList.add(w1);
        Worker w2 = new Worker("name2", "surname2", "phoneNum2", 500.2);
        workersList.add(w2);

        WorkingClient wc1 = new WorkingClient("name1", "surname1", "phoneNum1", 500.1, true, 10.0);
        clientsList.add(wc1);
        workersList.add(wc1);
        WorkingClient wc2 = new WorkingClient("name2", "surname2", "phoneNum2", 500.2, true, 10.0);
        clientsList.add(wc2);
        workersList.add(wc2);
    }
}