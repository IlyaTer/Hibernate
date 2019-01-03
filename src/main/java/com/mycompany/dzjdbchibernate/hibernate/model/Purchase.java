package com.mycompany.dzjdbchibernate.hibernate.model;

import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.io.Serializable;
import java.util.Date;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Purchases")
public class Purchase implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="NUMBER")
    private Integer number;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "PDATE")
    private Date date;
    
    @ManyToOne(cascade=ALL)
    @JoinColumn(name="STORE")
    private Store store;
    
    @ManyToOne(cascade=ALL)
    @JoinColumn(name="CUSTOMER")
    private Customer customer;
    
    @ManyToOne(cascade=ALL)
    @JoinColumn(name="BOOK")
    private Book book;
    
    @Column(name="COUNT")
    private Integer count;
    
    @Column(name="PRICE")
    private Double price;

    public Purchase() {
    }    

    public Purchase(Integer number, Date date, Store store, Customer customer, Book book, Integer count, Double price) {
        this.number = number;
        this.date = date;
        this.store = store;
        this.customer = customer;
        this.book = book;
        this.count = count;
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Purchase{" + "number=" + number + ", date=" + date +
                ", \n       store=" + store + ", \n       customer=" 
                + customer + ", \n       book=" + book 
                + ", \n       count=" + count + ", price=" + price + '}';
    }
    
}//end Perchase
