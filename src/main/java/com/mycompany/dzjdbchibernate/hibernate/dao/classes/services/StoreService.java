package com.mycompany.dzjdbchibernate.hibernate.dao.classes.services;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IStoreDao;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.StoreDaoService;
import com.mycompany.dzjdbchibernate.hibernate.model.Store;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(value = "storeSrvice")
public class StoreService implements StoreDaoService {

    @Resource(name = "storeDao")
    private IStoreDao storeDao;

    @Override
    public Store add(Store store) {
        storeDao.addUpdate(store);
        return store;
    }

    @Override
    public Store update(Store store) {
        storeDao.addUpdate(store);
        return store;
    }

    @Override
    public List<Store> findAll() {
        return storeDao.findAll();
    }

    @Override
    public List<Store> findAllWithDetail() {
        return storeDao.findAllWithDetail();
    }

    @Override
    public int countRow() {
        return storeDao.findAll().size();
    }

    @Override
    public Store findById(Integer id) {
        return storeDao.findById(id);
    }

    @Override
    public void delete(Store store) {
        storeDao.delete(store);
    }

    public IStoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(IStoreDao storeDao) {
        this.storeDao = storeDao;
    }

}//end storeService
