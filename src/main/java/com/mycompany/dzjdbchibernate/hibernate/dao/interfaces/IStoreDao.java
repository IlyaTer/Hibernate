package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.List;

public interface IStoreDao {
    
    Store addUpdate(Store store);
    
    List<Store> findAll();
    
    List<Store> findAllWithDetail();
    
    Store findById(Integer id);
    
    void delete(Store store);
}
