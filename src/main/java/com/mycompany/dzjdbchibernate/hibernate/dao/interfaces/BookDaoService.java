
package com.mycompany.dzjdbchibernate.hibernate.dao.interfaces;

import com.mycompany.dzjdbchibernate.hibernate.model.Book;
import java.util.List;


public interface BookDaoService {
    
    Book add(Book book);
    
    Book update(Book book);
    
    int countRow();
    
    List<Book> findAll();
    
    List<Book> findAllWithDetail();
    
    Book findById(Integer id);
    
    void delete(Book book);
}
