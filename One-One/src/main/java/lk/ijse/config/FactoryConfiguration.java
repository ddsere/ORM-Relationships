package lk.ijse.config;

import lk.ijse.entity.Customer;
import lk.ijse.entity.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        // xml, property files
        Configuration configuration = new Configuration();
        configuration.configure();
        // config entity class
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Passport.class);
        // create session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ?
                factoryConfiguration = new FactoryConfiguration() :
                factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}


