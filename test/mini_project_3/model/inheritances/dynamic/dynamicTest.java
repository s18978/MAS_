package mini_project_3.model.inheritances.dynamic;
import mini_project_3.exception.ValidationException;
import org.junit.Test;

public class dynamicTest {

    @Test
    public void test() {

        Person personClient = new Person("nameC", "surnameC", "11 999 888 444 333", true);

        personClient.getLoyaltyCard();

        try {
            personClient.getSalary();
        } catch (ValidationException e) {
            //
        }

        personClient.becomeWorker(4);
        personClient.getSalary();

        try {
            personClient.getLoyaltyCard();
        } catch (ValidationException e) {
            //
        }
    }
}