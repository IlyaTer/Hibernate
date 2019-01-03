package com.mycompany.dzjdbchibernate.hibernate.dao.classes.services;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IPurchaseDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.PurchaseDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Purchase;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "purchaseSrvice")
public class PurchaseService implements PurchaseDaoService {
    
    @Resource(name = "purchDao")
    private IPurchaseDao purchaseDao;

    @Override
    public Purchase add(Purchase purchase) {
        purchaseDao.addUpdate(purchase);
        return purchase;
    }

    @Override
    public Purchase update(Purchase purchase) {
        purchaseDao.addUpdate(purchase);
        return purchase;
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseDao.findAll();
    }

    @Override
    public Purchase findById(Integer id) {
        return purchaseDao.findById(id);
    }

    @Override
    public int countRow() {
        return purchaseDao.findAll().size();
    }

    @Override
    public void delete(Purchase purchase) {
        purchaseDao.delete(purchase);
    }
    
    public IPurchaseDao getPurchaseDao() {
        return purchaseDao;
    }

    public void setPurchaseDao(IPurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }
    
}// purchaseService
