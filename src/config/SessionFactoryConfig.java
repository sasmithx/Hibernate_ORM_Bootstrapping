package config;

import entity.CustomerOld;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        /*//1.Create Service Registry

        StandardServiceRegistry serviceRegistry
                = ;

        //2.Create Metadata Object

        Metadata metadata = ;*/

        //3.Create a SessionFactory
         /*sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                 .configure()
                 .build())
                 .addAnnotatedClass(Customer.class)
                 .getMetadataBuilder()
                 .build()
                .buildSessionFactory();*/
         sessionFactory = new Configuration()
                 .configure()
                 .addAnnotatedClass(CustomerOld.class)
                 .buildSessionFactory();
    }

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


       //creates and open the session
        return sessionFactory.openSession();
    }

}
