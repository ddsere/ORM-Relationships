package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Item;
import lk.ijse.entity.Orders;
import org.hibernate.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create and save the item first
            Item item = new Item();
            item.setName("Laptop");
            item.setQty(10);
            item.setPrice(999.99);
            session.persist(item);

            // Create orders
            Orders order1 = new Orders();
            order1.setOrderDate(Date.valueOf(LocalDate.now()));
            order1.getItems().add(item);
            session.persist(order1);

            Orders order2 = new Orders();
            order2.setOrderDate(Date.valueOf(LocalDate.now()));
            order2.getItems().add(item);
            session.persist(order2);

            // Update the item's orders list (inverse side)
            item.getOrders().add(order1);
            item.getOrders().add(order2);

            transaction.commit();
            System.out.println("Data saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}