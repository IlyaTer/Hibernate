package com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IStoreDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("storeDao")
public class StoreDaoImpl implements IStoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Store addUpdate(Store store) {
        sessionFactory.getCurrentSession().saveOrUpdate(store);
        return store;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Store s").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAllWithDetail() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Store.findAllWithDetail").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Store findById(Integer id) {
        return (Store) sessionFactory.getCurrentSession()
                .createQuery("from Store s where id = :parId")
                .setParameter("parId", id).uniqueResult();
    }

    @Override
    public void delete(Store store) {
        sessionFactory.getCurrentSession().delete(store);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}//end StoreDaoImpl
