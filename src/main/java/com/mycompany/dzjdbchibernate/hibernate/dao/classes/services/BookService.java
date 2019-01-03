package com.mycompany.dzjdbchibernate.hibernate.dao.classes.services;

import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.BookDaoService;
import com.mycompany.dzjdbchibernate.hibernate.dao.interfaces.IBookDao;
import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service(value="bookSrvice")
public class BookService implements BookDaoService{
    
    @Resource(name="bookDao")
    private IBookDao bookDao;

    @Override
    public Book add(Book book) {
        bookDao.addUpdate(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        bookDao.addUpdate(book);
        return book;
    }

    @Override
    public int countRow() {
        return bookDao.findAll().size();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findAllWithDetail() {
        return bookDao.findAllWithDetail();
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }
    
    public IBookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }
    
}//end bookService
