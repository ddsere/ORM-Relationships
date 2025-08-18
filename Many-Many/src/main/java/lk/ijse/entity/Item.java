package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_qty")
    private int qty;

    @Column(name = "item_price")
    private double price;

    @ManyToMany(mappedBy = "items")
    private List<Orders> orders = new ArrayList<>();

}

//inverse side