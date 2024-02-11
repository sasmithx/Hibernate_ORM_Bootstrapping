import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        //1.save
        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = getCustomer();

        session.save(customer);

        transaction.commit();

        session.close();
        System.out.println("-----SAVE-----");
        //2. Get
        System.out.println("-----GET-----");
        Session getSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer existingCustomer =
                getSession
                .get(Customer.class, 2);

        System.out.println("Existing Customer :" + existingCustomer);

        getSession.close();


        //3. Update
        System.out.println("-----UPDATE-----");
        Session updateSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction updateTransaction = updateSession.beginTransaction();

        Customer existingCus = updateSession.get(Customer.class, 2);

        existingCus.setAddress("Matara");
        updateSession.update(existingCus);
        updateTransaction.commit();
        updateSession.close();


        //4. delete
        System.out.println("-----DELETE-----");
        Session deleteSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction deleteTransaction = deleteSession.beginTransaction();

        Customer existingCustomerDelete = deleteSession.get(Customer.class, 2);
        deleteSession.delete(existingCustomerDelete);
        deleteTransaction.commit();
        deleteSession.close();
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(75000);
        return customer;
    }
}
