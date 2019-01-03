package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import java.util.List;

public interface IBookDao {
    
    Book addUpdate(Book book);
    
    List<Book> findAll();
    
    List<Book> findAllWithDetail();
    
    Book findById(Integer id);
    
    void delete(Book book);
    
}
