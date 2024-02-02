import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000);


    }
}
