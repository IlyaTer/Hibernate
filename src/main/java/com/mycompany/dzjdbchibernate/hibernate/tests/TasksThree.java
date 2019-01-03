package com.mycompany.dzjdbchibernate.hibernate.tests;

import com.mycompany.dzjdbchibernate.hibernate.dao.classes.services.StoreService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.BookDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.CustomerDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.context.ApplicationContext;

public class TasksThree {

    private ApplicationContext context;

    private static class ForAObject {

        private String surname;
        private Double discount;

        public ForAObject(String surname, Double discount) {
            this.surname = surname;
            this.discount = discount;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 41 * hash + Objects.hashCode(this.surname);
            hash = 41 * hash + Objects.hashCode(this.discount);
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
            if (!Objects.equals(this.surname, other.surname)) {
                return false;
            }
            if (!Objects.equals(this.discount, other.discount)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "surname=" + surname + ", discount=" + discount + '}';
        }

    }//end ForAObject 

    private static class ForCObject {

        private String name;
        private Double price;

        public ForCObject(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 53 * hash + Objects.hashCode(this.name);
            hash = 53 * hash + Objects.hashCode(this.price);
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
            final ForCObject other = (ForCObject) obj;
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

    }//end ForCObject

    public TasksThree(ApplicationContext context) {
        this.context = context;
    }

    private Set<ForAObject> taskA() {
        Set<ForAObject> resSet = new HashSet<>();
        CustomerDaoService cust = context.getBean("customerService",
                CustomerDaoService.class);

        for (Customer c : cust.findAll()) {
            if (c.getDistrict().equals("District 1")) {
                resSet.add(new ForAObject(c.getSurname(), c.getDiscount()));
            }
        }

        return resSet;
    }//end taskA

    private Set<String> taskB() {
        Set<String> resSet = new HashSet<>();
        StoreService st = context.getBean("storeSrvice", StoreService.class);

        for (Store s : st.findAll()) {
            if (s.getDistrict().equals("District 1")
                    || s.getDistrict().equals("District 2")) {
                resSet.add(s.getDistrict());
            }
        }

        return resSet;
    }//end taskB

    private Set<ForCObject> taskC() {
        Set<ForCObject> resSet = new HashSet<>();
        BookDaoService books = context.getBean("bookSrvice", BookDaoService.class);

        for (Book b : books.findAll()) {
            if (b.getName().contains("Windows")
                    || b.getPrice() > 20000.0) {
                resSet.add(new ForCObject(b.getName(), b.getPrice()));
            }
        }

        return resSet;
    }//end taskC

    public void start() {
        System.out.println("Task set 3");
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
        for (ForCObject str : taskC()) {
            System.out.println(str);
        }
        System.out.println();
    }

}//end Tasks 3
