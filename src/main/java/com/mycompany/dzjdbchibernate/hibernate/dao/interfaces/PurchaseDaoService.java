package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.List;


public interface PurchaseDaoService {
    
    Purchase add(Purchase purchase);
    
    Purchase update(Purchase purchase);
    
    List<Purchase> findAll();
    
    Purchase findById(Integer id);
    
    int countRow();
    
    void delete(Purchase purchase);
}
