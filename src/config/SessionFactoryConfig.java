package config;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private SessionFactoryConfig() {}

    public static SessionFactoryConfig getInstance(){
        if (null == factoryConfig){
            factoryConfig = new SessionFactoryConfig();
            return factoryConfig;
        }else {
            return factoryConfig;
        }
    }

}
