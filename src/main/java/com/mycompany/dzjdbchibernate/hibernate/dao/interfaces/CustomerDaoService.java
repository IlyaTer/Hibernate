package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import java.util.List;


public interface CustomerDaoService {
    
    Customer add(Customer customer);
    
    Customer update(Customer customer);
    
    List<Customer> findAll();
    
    List<Customer> findAllWithDetail();
    
    int countRow();
    
    Customer findById(Integer id);
    
    void delete(Customer customer);    
}
