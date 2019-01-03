package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import java.util.List;

public interface ICustomerDao {
    
    Customer addUpdate(Customer customer);
    
    List<Customer> findAll();
    
    List<Customer> findAllWithDetail();
    
    Customer findById(Integer id);
    
    void delete(Customer customer);
    
}
