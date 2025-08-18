package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction trasaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName("John");

        Orders order1 = new Orders();
        order1.setOrderDate(Date.valueOf(LocalDate.now()));
        order1.setCustomer(customer);

        Orders order2 = new Orders();
        order2.setOrderDate(Date.valueOf(LocalDate.now()));
        order2.setCustomer(customer);

        List<Orders> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        customer.setOrders(orders);

        session.persist(customer);
        trasaction.commit();
    }
}