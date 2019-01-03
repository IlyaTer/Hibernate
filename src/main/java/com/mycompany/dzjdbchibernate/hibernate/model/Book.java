package com.mycompany.dzjdbchibernate.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Books")
@NamedQueries({
@NamedQuery(name = "Book.findAllWithDetail",
    query="select distinct b from Book b left join fetch b.purchases")
})
public class Book implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="Price")
    private Double price;
    
    @Column(name="STORAGE")
    private String storage;
    
    @Column(name="COUNT")
    private Integer count;
    
    @OneToMany(mappedBy = "book", cascade=CascadeType.ALL,
        orphanRemoval=true)
    private Set<Purchase> purchases = new HashSet<>(); 

    public Book() {
    }

    public Book(Integer id, String name, Double price, String storage, Integer count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.storage = storage;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
        
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", price=" + price + ", storage=" + storage + ", count=" + count + '}';
    }
    
    
}//end Book
