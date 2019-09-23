package com.eagle.ykm.service;

import com.eagle.ykm.dao.BookDAO;
import com.eagle.ykm.model.Book;
import com.eagle.ykm.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 14:12
 **/
@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBook() {
        return bookDAO.findAll();
    }


    public int addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public void deleteBooks(int id) {
         bookDAO.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
    }

    //还书
    public void recoverBooks(int id) {
        bookDAO.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
    }











}