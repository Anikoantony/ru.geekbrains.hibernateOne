package ru.mvgrebenyuk.hiberOne;

import javax.persistence.*;

@Entity // обязательная анатация для Hybernete
@Table(name = "products")
public class Product {
    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Id")
    private Long id;
    // в случае исключения @Transient
    @Column(name = "title")
    private String title;

    @Column(name="price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "costumers_id")
    private Costumer costumer;

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
