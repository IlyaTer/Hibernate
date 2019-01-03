package com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IPurchaseDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("purchDao")
public class PurchaseDaoImpl implements IPurchaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Purchase addUpdate(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Purchase> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Purchase p").list();
    }

    @Override
    public Purchase findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Purchase purchase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
