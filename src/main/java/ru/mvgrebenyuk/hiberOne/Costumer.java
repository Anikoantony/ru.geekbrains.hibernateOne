package ru.mvgrebenyuk.hiberOne;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_cust")
    private String name_cust;

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", name_cust='" + name_cust + '\'' +
                '}';
    }

   @OneToMany(mappedBy = "costumer", fetch = FetchType.EAGER)
   private List<Product> products;

    public String getName_cust() {
        return name_cust;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
