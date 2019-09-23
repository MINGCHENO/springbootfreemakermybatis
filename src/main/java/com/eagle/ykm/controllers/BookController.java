package com.eagle.ykm.controllers;

import com.eagle.ykm.model.Book;
import com.eagle.ykm.model.User;
import com.eagle.ykm.service.BookService;
import com.eagle.ykm.service.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description
 * @auth YKM
 * @date 2019/9/20 18:39
 **/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private HostHolder hostHolder;

    /*查询所有图书*/
    @RequestMapping(path = {"/index"},method = {RequestMethod.GET})
    public String bookList(Model model) {
        User host = hostHolder.getUser();

        if (host != null) {
            model.addAttribute("host", host);
        }
        loadAllBookView(model);
        return "book/books";
    }

    @RequestMapping(path = {"/book/add"}, method = {RequestMethod.GET})
    public String addBook() {
        return "book/addBook";
    }

    /*添加图书*/
    @RequestMapping(path = {"books/add/do"}, method = {RequestMethod.POST})
    public String doAddBook(@RequestParam("name") String name,
                            @RequestParam("author") String author,
                            @RequestParam("price") String price) {

        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        bookService.addBook(book);
        return "redirect:/index";
    }

    /*根据bookId删除图书*/
    @RequestMapping(path = {"/books/{bookId:[0-9]+}/delete"},method = {RequestMethod.GET})
    public String deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBooks(bookId);
        return "redirect:/index";
    }

    /*根据bookId还书*/
    @RequestMapping(path = {"/books/{bookId:[0-9]+}/recover"}, method = {RequestMethod.GET})
    public String recoverBook(@PathVariable("bookId") int bookId) {
        bookService.recoverBooks(bookId);
        return "redirect:index";
    }

    /*
     * @Param: 所有的book添加到book中
     * @Author: Administrator
     * @Time 16:29
     * @return:
    **/
    private void loadAllBookView(Model model) {
        /*addAttribute参数: string, object*/
        model.addAttribute("books", bookService.getAllBook());
    }




}