package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data //@Getter @Setter @ToString
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "cus_id")
    private Customer customer;
}

//owning side