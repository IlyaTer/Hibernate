package com.mycompany.dzjdbchibernate.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Customers")
@NamedQueries({
@NamedQuery(name = "Customer.findAllWithDetail",
    query="select distinct c from Customer c left join fetch c.purchases")
})
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="SURNAME")
    private String surname;
    
    @Column(name="DISTRICT")
    private String district;
    
    @Column(name="DISCOUNT")
    private Double discount;
    
    @OneToMany(mappedBy = "customer", cascade=CascadeType.ALL,
        orphanRemoval=true)
    private Set<Purchase> purchases = new HashSet<>();

    public Customer() {
    }

    public Customer(Integer id, String surname, String district, Double discount) {
        this.id = id;
        this.surname = surname;
        this.district = district;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", surname=" + surname + ", district=" + district + ", discount=" + discount + '}';
    }
    
}//end Customer

