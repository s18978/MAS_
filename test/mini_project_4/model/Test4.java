package mini_project_4.model;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class Test4 {

    @Test
    public void forAttributeTest() {
        Contract contract = new Contract(LocalDate.now(), 5400,
                new Worker("b", "v", "999999999"), new Shop("v"));
        assertEquals(5400, contract.getSalary(), 1);
        contract.setSalary(7000);
        assertEquals(7000, contract.getSalary(), 1);
        try { contract.setSalary(2000);
        } catch (Exception e) {
            return;
        }
        fail();
    }

    @Test
    public void uniqueTest() {
        Account account = new Account(1);
        Account account1 = new Account(2);

        assertEquals(1, account.getId());
        assertEquals(2, account1.getId());

        try {
            account.setId(1);
        } catch (Exception e) {
            return;
        }
        fail();
    }

    @Test
    public void subsetTest() {
        Worker worker = new Worker("g", "g", "999999999");
        Worker worker1 = new Worker("g", "g", "999999999");
        Shift shift = new Shift("f", worker);
        assertTrue(shift.getWorkers().contains(worker));
        assertEquals(worker, shift.getManager());
        shift.addWorker(worker1);
        assertTrue(shift.getWorkers().contains(worker));
        assertTrue(shift.getWorkers().contains(worker1));
        assertEquals(worker, shift.getManager());
    }

    @Test
    public void orderedTest() {
        Shop shop = new Shop("g");
        Client client = new Client("g");
        Client client1 = new Client("g");
        shop.addClient(client);
        assertEquals(client, shop.getClients().get(0));
        assertEquals(shop, client.getShops().get(0));
        client1.addShops(shop);
        assertEquals(client1, shop.getClients().get(1));
        assertEquals(shop, client.getShops().get(0));
        shop.addClient(client1);
        assertEquals(2, shop.getClients().size());
    }

    @Test
    public void bagTest() {
        Worker worker = new Worker("f", "g", "999999999");
        Shop shop = new Shop("f");

        Contract contract = new Contract(LocalDate.now(), 5000, worker, shop);

        assertTrue(worker.getContracts().contains(contract));
        assertTrue(shop.getContracts().contains(contract));
        assertEquals(1, worker.getContracts().size());
        assertEquals(1, shop.getContracts().size());

        Contract contract1 = new Contract(LocalDate.now(), 5000, worker, shop);

        assertTrue(worker.getContracts().contains(contract1));
        assertTrue(shop.getContracts().contains(contract1));
        assertEquals(2, worker.getContracts().size());
        assertEquals(2, shop.getContracts().size());
        assertEquals(2, Contract.getExtent().size());

        contract.delete();
        assertFalse(worker.getContracts().contains(contract));
        assertFalse(shop.getContracts().contains(contract));
        assertEquals(1, worker.getContracts().size());
        assertEquals(1, shop.getContracts().size());

        worker.removeContract(contract1);
        assertFalse(worker.getContracts().contains(contract1));
        assertFalse(shop.getContracts().contains(contract1));
        assertEquals(0, worker.getContracts().size());
        assertEquals(0, shop.getContracts().size());
        assertEquals(0, Contract.getExtent().size());
    }

    @Test
    public void xorTest() {
        Worker worker = new Worker("g","g","999999999");
        Client client = new Client("v");

        Account account = new Account(3);
        account.setWorker(worker);

        assertEquals(worker,account.getWorker());
        assertEquals(account,worker.getAccount());

        try {
            account.setClient(client);
        }
        catch (Exception e) {

            Account account1 = new Account(4);
            account1.setClient(client);

            assertEquals(client,account1.getClient());
            assertEquals(account1,client.getAccount());

            try {
                account1.setWorker(worker);
            } catch (Exception e1) {
                return;
            }
        }
        fail();
    }

    @Test
    public void customBusinessTest() {
        Worker worker = new Worker("f", "g", "999999999");
        Worker worker1 = new Worker("f", "g", "999999999");
        Shop shop = new Shop("f");

        Contract contract = new Contract(LocalDate.now(), 5500, worker, shop);
        Contract contract0 = new Contract(LocalDate.now(), 3200, worker, shop);
        Contract contract1 = new Contract(LocalDate.now(), 3400, worker1, shop);

        Cabinet cabinet = new Cabinet(4);
        cabinet.setWorker(worker);
        assertEquals(cabinet, worker.getCabinet());
        assertEquals(worker, cabinet.getWorker());
        worker1.setCabinet(cabinet);
        assertNull(worker1.getCabinet());
    }
}