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
@Table(name="Stores")
@NamedQueries({
@NamedQuery(name = "Store.findAllWithDetail",
    query="select distinct s from Store s left join fetch s.purchases")
})
public class Store implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="DISTRICT")
    private String district;
    
    @Column(name="COMMISSIONS")
    private Double commissions;

    @OneToMany(mappedBy = "store", cascade=CascadeType.ALL,
        orphanRemoval=true)
    private Set<Purchase> purchases = new HashSet<>();
   
    public Store() {
    }

    public Store(Integer id, String name, String district, Double commissions) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.commissions = commissions;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getCommissions() {
        return commissions;
    }

    public void setCommissions(Double commissions) {
        this.commissions = commissions;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }


    @Override
    public String toString() {
        return "Store{" + "id=" + id + ", name=" + name + ", district=" + district + ", commissions=" + commissions + '}';
    }
   
    
}//end store
