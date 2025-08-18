package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Passport;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("John");

        Passport passport = new Passport();
        passport.setPassportNumber("E123456");

        customer.setPassport(passport);

        session.persist(customer);
        transaction.commit();
    }
}