package repository;

import config.SessionFactoryConfig;
import entity.CustomerOld;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public int saveCustomer(CustomerOld customer){
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
    public CustomerOld getCustomer(int id) throws RuntimeException{
        try{
            CustomerOld customer = session.get(CustomerOld.class, id);
            session.close();
            return customer;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateCutomer(CustomerOld customer){
        Transaction transaction = session.beginTransaction();
        try{
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        }catch(Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(CustomerOld customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
}
