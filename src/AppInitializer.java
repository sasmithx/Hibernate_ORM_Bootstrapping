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

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());
        System.out.println("------SAVE APPINIT------");

        //2.Get

        customerRepository =  new CustomerRepository();
        Customer customer = customerRepository.getCustomer(getCustomer().getId());
        System.out.println(customer);
        System.out.println("-----GET_ID-----");

        //3.update

        customerRepository = new CustomerRepository();
        customer.setAddress("Matara");
        boolean isUpdated = customerRepository.updateCutomer(customer);

        if(isUpdated){
            System.out.println("Customer Updated");
        }else {
            System.out.println("Update Failed");
        }

        System.out.println("------UPDATE------");

       //4.delete

        customerRepository = new CustomerRepository();
        customerRepository.deleteCustomer(customer);

        System.out.println("------DELETE------");
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
