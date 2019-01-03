package com.mycompany.dzjdbchibernate.hibernate.tests;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.BookDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.CustomerDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.PurchaseDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.context.ApplicationContext;

public class TasksTwo {

    private ApplicationContext context;

    private static class ForAObject {

        private String name;
        private Double price;

        public ForAObject(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + Objects.hashCode(this.name);
            hash = 73 * hash + Objects.hashCode(this.price);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ForAObject other = (ForAObject) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (!Objects.equals(this.price, other.price)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "name=" + name + ", price=" + price + '}';
        }

    }//end bClass

    public TasksTwo(ApplicationContext context) {
        this.context = context;
    }

    private Set<ForAObject> taskA() {
        Set<ForAObject> resSet = new HashSet<>();
        BookDaoService books = context.getBean("bookSrvice", BookDaoService.class);

        for (Book b : books.findAll()) {
            resSet.add(new ForAObject(b.getName(), b.getPrice()));
        }

        return resSet;
    }//end TaskA

    private Set<String> taskB() {
        Set<String> resSet = new HashSet<>();
        CustomerDaoService cust = context.getBean("customerService",
                CustomerDaoService.class);

        for (Customer c : cust.findAll()) {
            resSet.add(c.getDistrict());
        }

        return resSet;
    }//end taskB

    private Set<String> taskC() {
        Set<String> resSet = new HashSet<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice",
                PurchaseDaoService.class);

        for (Purchase p : purch.findAll()) {
            resSet.add(p.getDate().toString().split("-")[1]);
        }

        return resSet;
    }

    public void start() {
        System.out.println("Task set 2");
        System.out.println();
        System.out.println("Task A:");
        for (ForAObject obj : taskA()) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("Task B:");
        for (String str : taskB()) {
            System.out.println(str);
        }
        System.out.println();

        System.out.println("Task C:");
        for (String str : taskC()) {
            System.out.println(str);
        }
        System.out.println();
    }
}//end TasksTwo

