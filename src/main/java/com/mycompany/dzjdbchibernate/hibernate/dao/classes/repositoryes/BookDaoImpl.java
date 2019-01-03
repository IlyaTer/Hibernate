package com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IBookDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("bookDao")
public class BookDaoImpl implements IBookDao {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book addUpdate(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
        return book;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book b").list();
    }

    @Override
    @Transactional(readOnly=true)
    public Book findById(Integer id) {
        return (Book) sessionFactory.getCurrentSession()
                .createQuery("from Book b where id = :parId")
                .setParameter("parId", id).uniqueResult();
    }

    @Override
    public void delete(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Book> findAllWithDetail() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("Book.findAllWithDetail").list();
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
}//end BookDao
