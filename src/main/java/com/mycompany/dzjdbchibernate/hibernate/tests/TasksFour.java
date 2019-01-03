package com.mycompany.dzjdbchibernate.hibernate.tests;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.PurchaseDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.context.ApplicationContext;


public class TasksFour {
    
    private ApplicationContext context;
    
    private static class ForAObject{
        private Integer id;
        private String nameStorage;
        private String district;

        public ForAObject(Integer id, String nameStorage, String district) {
            this.id = id;
            this.nameStorage = nameStorage;
            this.district = district;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 29 * hash + Objects.hashCode(this.id);
            hash = 29 * hash + Objects.hashCode(this.nameStorage);
            hash = 29 * hash + Objects.hashCode(this.district);
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
            if (!Objects.equals(this.nameStorage, other.nameStorage)) {
                return false;
            }
            if (!Objects.equals(this.district, other.district)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "id=" + id + ", nameStorage=" + nameStorage + ", district=" + district + '}';
        }
                
    }//end ForAObject

    private static class ForBObject{
        
        private Integer id;
        private Date date;
        private String surname;
        private Double discount;
        private String name;
        private Integer count;

        public ForBObject(Integer id, Date date, String surname, Double discount, String name, Integer count) {
            this.id = id;
            this.date = date;
            this.surname = surname;
            this.discount = discount;
            this.name = name;
            this.count = count;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 41 * hash + Objects.hashCode(this.id);
            hash = 41 * hash + Objects.hashCode(this.date);
            hash = 41 * hash + Objects.hashCode(this.surname);
            hash = 41 * hash + Objects.hashCode(this.discount);
            hash = 41 * hash + Objects.hashCode(this.name);
            hash = 41 * hash + Objects.hashCode(this.count);
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
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            if (!Objects.equals(this.date, other.date)) {
                return false;
            }
            if (!Objects.equals(this.discount, other.discount)) {
                return false;
            }
            if (!Objects.equals(this.count, other.count)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "{" + "id=" + id + ", date=" + date + ", surname=" + surname + ", discount=" + discount + ", name=" + name + ", count=" + count + '}';
        }
        
    }//end ForBObject
    
    public TasksFour(ApplicationContext context) {
        this.context = context;
    }
    
    private Set<ForAObject> taskA(){
        Set<ForAObject> resSet = new HashSet<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice", 
                PurchaseDaoService.class);
        
        for(Purchase p: purch.findAll())
        {
            resSet.add(new ForAObject(p.getNumber(), p.getStore().getName()
                    ,p.getStore().getDistrict()));
        }
        
        return resSet;
    }// taskA
    
    private Set<ForBObject> taskB(){
        Set<ForBObject> resSet = new HashSet<>();
        PurchaseDaoService purch = context.getBean("purchaseSrvice", 
                PurchaseDaoService.class);
        
        for(Purchase p: purch.findAll())
        {
            resSet.add(new ForBObject(p.getNumber(), p.getDate(),
                    p.getCustomer().getSurname(), p.getCustomer().getDiscount(),
                    p.getBook().getName(), p.getCount()));
        }
        
        return resSet;
    }
    
    public void start(){
        System.out.println("Task set 4");
        System.out.println();
        System.out.println("Task A:");
        for (ForAObject obj : taskA()) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("Task B:");
        for (ForBObject obj: taskB()) {
            System.out.println(obj);
        }
        System.out.println();

        System.out.println();
    }//end start
}//end TasksFour 
