package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.List;


public interface StoreDaoService {
    
    Store add(Store store);
    
    Store update(Store store);
    
    List<Store> findAll();
    
    List<Store> findAllWithDetail();
    
    int countRow();
    
    Store findById(Integer id);
    
    void delete(Store store);
}
