package ru.mvgrebenyuk.hiberOne;

import javax.persistence.*;

@Entity // обязательная анатация для Hybernete
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name="cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "costumers_id")
    private Costumer costumer;

    public Costumer getCostumer() {
        return costumer;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Product() {
    }

}
