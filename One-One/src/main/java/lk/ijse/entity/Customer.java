package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data //@Getter @Setter @ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //delete - REMOVE
    //update - MERGE
    //save - PERSIST
    //We can use cascade ALL instead above 3 types
//    @OneToOne(cascade = {
//            CascadeType.REMOVE,
//            CascadeType.MERGE,
//            CascadeType.PERSIST})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;
}

//owning side
//having foreign key on DB
