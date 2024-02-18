package repository;

import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(Customer customer){
        System.out.println("------SAVE------");


        Transaction transaction = session.beginTransaction();
        try{
            int customerID = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerID;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }
}
