package config;

import org.hibernate.Session;

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

    }

}
