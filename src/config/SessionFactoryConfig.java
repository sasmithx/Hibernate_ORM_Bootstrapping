package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance(){
        /*if (null == factoryConfig){
            factoryConfig = new SessionFactoryConfig();
            return factoryConfig;
        }else {
            return factoryConfig;
        }*/

      return   (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession(){
        //1.Create Service Registry

        StandardServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        //2.Create Metadata Object

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .build();

        //3.Create a SessionFactory
        SessionFactory sessionFactory = metadata
                .buildSessionFactory();

       //creates and open the session
        return sessionFactory.openSession();
    }

}
