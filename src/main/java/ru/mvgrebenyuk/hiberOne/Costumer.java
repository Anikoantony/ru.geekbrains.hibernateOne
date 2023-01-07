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


    public List<Product> getProducts() {
        return products;
    }



    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                                '}';
    }

    @Column(name = "fio")
    private String fio;

    @OneToMany (mappedBy = "costumer", fetch = FetchType.LAZY)
    private List<Product> products;


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
