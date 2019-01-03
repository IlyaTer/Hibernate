package com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.ICustomerDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customer addUpdate(Customer customer) {
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
        return customer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Customer c").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findById(Integer id) {
        return (Customer) sessionFactory.getCurrentSession()
                .createQuery("from Customer c where id = :parId")
                .setParameter("parId", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAllWithDetail() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Customer.findAllWithDetail").list();
    }

    @Override
    public void delete(Customer customer) {
        sessionFactory.getCurrentSession().delete(customer);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}//end CustomerDaoImpl
