package mini_project_3.model.inheritances.overlapping;
import mini_project_3.exception.ValidationException;
import org.junit.Test;

public class overlappingTest {

    @Test
    public void test() {

        Person personClient = new Person("nameC", "surnameC", "11 999 888 444 333", true);
        Person personWorker = new Person("nameW", "surnameW", "22 999 888 444 333", 500.5);
        Person personClient_Worker = new Person("nameCW", "surnameCW", "33 999 888 444 333", true, 600.6);

        personClient.getLoyaltyCard();

        try {
            personClient.getSalary();
        } catch (ValidationException e) {
            //
        }

        personWorker.getSalary();

        try {
            personWorker.getLoyaltyCard();
        } catch (ValidationException e) {
            //
        }

        personClient_Worker.getLoyaltyCard();
        personClient_Worker.getSalary();

    }
}