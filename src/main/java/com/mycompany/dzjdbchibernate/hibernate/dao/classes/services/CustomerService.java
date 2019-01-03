package com.mycompany.dzjdbchibernate.hibernate.dao.classes.services;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.CustomerDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.ICustomerDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerService implements CustomerDaoService {

    @Resource(name = "customerDao")
    private ICustomerDao customerDao;

    @Override
    public Customer add(Customer customer) {
        customerDao.addUpdate(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        customerDao.addUpdate(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public List<Customer> findAllWithDetail() {
        return customerDao.findAllWithDetail();
    }

    @Override
    public int countRow() {
        return customerDao.findAll().size();
    }

    @Override
    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }
    
    public ICustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}//end customerService
