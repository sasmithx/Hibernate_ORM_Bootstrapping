package config;

import org.hibernate.Session;
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

        StandardServiceRegistry serviceRegistr
                = new StandardServiceRegistryBuilder()
                .configure()
                .build();
    }

}
