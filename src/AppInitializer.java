import config.SessionFactoryConfig;
import embedded.MobileNumber;
import embedded.NameIdentifier;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        //1.Save
        /*System.out.println("------SAVE------");
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = getCustomer();

        session.save(customer);
        transaction.commit();
        session.close();*/

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());
        System.out.println("------SAVE APPINIT------");

        //2.Get
        /*System.out.println("------GET------");
        Session getsSession = SessionFactoryConfig.getInstance().getSession();
        Customer existingCustomer = getsSession.get(Customer.class,1);
        System.out.println("Existing Customer: " + existingCustomer);
        getsSession.close();
        System.out.println("------GET------");*/

        customerRepository =  new CustomerRepository();
        Customer customer = customerRepository.getCustomer(getCustomer().getId());
        System.out.println(customer);
        System.out.println("-----GET_ID-----");

        //3.update
        /*System.out.println("------UPDATE------");
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Customer existingCus = updateSession.get(Customer.class, 1);

        Transaction updateTransaction = updateSession.beginTransaction();
        existingCus.setAddress("Matara");
        updateSession.update(existingCus);
        updateTransaction.commit();
        updateSession.close();*/

        customerRepository = new CustomerRepository();
        customer.setAddress("Matara");
        customerRepository.updateCutomer(customer);

        System.out.println("------UPDATE------");

       /* //4.delete
        System.out.println("------DELETE------");
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Customer existingCusDelete = deleteSession.get(Customer.class, 1);

        Transaction deleteTransaction = deleteSession.beginTransaction();
        deleteSession.delete(existingCusDelete);
        deleteTransaction.commit();
        deleteSession.close();
        System.out.println("------DELETE------");*/
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(6);
        customer.setName(getNameIdentifier());
        //
        MobileNumber homeMobile = new MobileNumber();
        homeMobile.setType("HOME");
        homeMobile.setMobileNo("0411235997");

        MobileNumber mobileNo = new MobileNumber();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0702345768");

        MobileNumber No = new MobileNumber();
        mobileNo.setType("MOBILE_02");
        mobileNo.setMobileNo("070234998");

        List<MobileNumber> mobileNumbers = new ArrayList<>();
        mobileNumbers.add(homeMobile);
        mobileNumbers.add(mobileNo);
        mobileNumbers.add(No);
        //
        customer.setMobileNumbers(mobileNumbers);
        customer.setAddress("Rathnapura");
        customer.setSalary(65000.00);
        return customer;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("ASHEN");
        nameIdentifier.setMiddleName("sumudu");
        nameIdentifier.setLastName("ARAvinda");
        return nameIdentifier;
    }
}
