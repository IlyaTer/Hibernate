package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.List;

public interface IPurchaseDao {
    
    Purchase addUpdate(Purchase purchase);
    
    List<Purchase> findAll();
    
    Purchase findById(Integer id);
    
    void delete(Purchase purchase);
}
