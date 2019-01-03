package com.mycompany.dzjdbchibernate.hibernate.tests;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.PurchaseDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.StoreDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.context.ApplicationContext;

public class TasksFive {
    
    private ApplicationContext context;

    private static class ForAObject{
        private Integer id;
        private String surname;
        private Date date;

        public ForAObject(Integer id, String surname, Date date) {
            this.id = id;
            this.surname = surname;
            this.date = date;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 67 * hash + Objects.hashCode(this.id);
            hash = 67 * hash + Objects.hashCode(this.surname);
            hash = 67 * hash + Objects.hashCode(this.date);
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
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            if (!Objects.equals(this.date, other.date)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "id=" + id + ", surname=" + surname + ", date=" + date + '}';
        }
        
    }//end ForAObject
    
    private static class ForBObject{
        private Integer id;
        private String surname;
        private String district;
        private Date date;

        public ForBObject(Integer id, String surname, String district, Date date) {
            this.id = id;
            this.surname = surname;
            this.district = district;
            this.date = date;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Objects.hashCode(this.id);
            hash = 97 * hash + Objects.hashCode(this.surname);
            hash = 97 * hash + Objects.hashCode(this.district);
            hash = 97 * hash + Objects.hashCode(this.date);
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
            final ForBObject other = (ForBObject) obj;
            if (!Objects.equals(this.surname, other.surname)) {
                return false;
            }
            if (!Objects.equals(this.district, other.district)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            if (!Objects.equals(this.date, other.date)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "id=" + id + ", surname=" + surname + ", district=" + district + ", date=" + date + '}';
        }
        
    }//end ForBObject
    
    private static class ForDObject{
        private String name;
        private String storage;
        private Integer count;
        private Double price;

        public ForDObject(String name, String storage, Integer count, Double price) {
            this.name = name;
            this.storage = storage;
            this.count = count;
            this.price = price;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 31 * hash + Objects.hashCode(this.name);
            hash = 31 * hash + Objects.hashCode(this.storage);
            hash = 31 * hash + Objects.hashCode(this.count);
            hash = 31 * hash + Objects.hashCode(this.price);
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
            final ForDObject other = (ForDObject) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (!Objects.equals(this.storage, other.storage)) {
                return false;
            }
            if (!Objects.equals(this.count, other.count)) {
                return false;
            }
            if (!Objects.equals(this.price, other.price)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "name=" + name + ", storage=" + storage + ", count=" + count + ", price=" + price + '}';
        }

    }//end ForDObject
    
    public TasksFive(ApplicationContext context) {
        this.context = context;
    }
    
    private Set<ForAObject> taskA(){
        Set<ForAObject> resSet = new HashSet<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice", 
                PurchaseDaoService.class);
        
        for(Purchase p: purch.findAll())
        {
            if(p.getPrice() >= 60000.0)
            {
                resSet.add(new ForAObject(p.getNumber(), 
                        p.getCustomer().getSurname(), p.getDate()));
            }
        }
        
        return resSet;
    }//end taskA
    
    private Set<ForBObject> taskB(){
        Set<ForBObject> resSet = new HashSet<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice", 
                PurchaseDaoService.class);
        
        for(Purchase p: purch.findAll())
        {
            if(p.getCustomer().getDistrict().equals(
                    p.getStore().getDistrict()) && 
                    Integer.parseInt(p.getDate().toString().split("-")[1]) >= 5)
            {
                
                resSet.add(new ForBObject(p.getNumber(), 
                        p.getCustomer().getSurname(), 
                        p.getCustomer().getDistrict(), p.getDate()));
            }
        }
        
        return resSet;
    }
    
    private Set<String> taskC(){
        Set<String> resSet = new HashSet<>();
        StoreDaoService st = context.getBean("storeSrvice", 
                StoreDaoService.class);
        
        for(Store s: st.findAllWithDetail())
        {
            if(!s.getDistrict().equals("District 3"))
            {
                for(Purchase p: s.getPurchases())
                {
                    if(p.getCustomer().getDiscount() >= 10.0 &&
                            p.getCustomer().getDiscount() <= 15.0)
                    {
                        resSet.add(s.getDistrict());                        
                    }
                }//end pfor
            }//end sif
        }
        
        return resSet;
    }//end taskC
    
    private List<ForDObject> taskD(){
        List<ForDObject> resSet = new ArrayList<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice", 
                PurchaseDaoService.class);
        
        for(Purchase p: purch.findAll())
        {
            if(p.getBook().getStorage().equals(
                    p.getStore().getDistrict()) && 
               p.getBook().getCount() > 10)
            {
                resSet.add(new ForDObject(p.getBook().getName(), 
                    p.getBook().getStorage(), p.getBook().getCount(),
                    p.getBook().getPrice()));
            }
        }
        
        Collections.sort(resSet, (objA, objB)->
        {
            return Double.compare(objA.price, objB.price);
        });
        
        return resSet;
    }//end taskD
    
    public void start() {
        System.out.println("Task set 5");
        System.out.println();
        System.out.println("Task A:");
        for (ForAObject obj : taskA()) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("Task B:");
        for (ForBObject obj : taskB()) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("Task C:");
        for (String str : taskC()) {
            System.out.println(str);
        }
        
        
        System.out.println("Task D:");
        for (ForDObject obj : taskD()) {
            System.out.println(obj);
        }
        System.out.println();
    }
    
}//
