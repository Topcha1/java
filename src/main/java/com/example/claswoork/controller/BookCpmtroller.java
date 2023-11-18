package com.example.claswoork.controller;

import com.example.claswoork.utils.bookutils;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import com.example.claswoork.models.book;
import com.example.claswoork.controller.BookCpmtroller;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookCpmtroller {

    private final bookutils bookutils = com.example.claswoork.utils.bookutils.getInstance();
    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public book addBook(@RequestBody book book){
        bookutils.addbook(book);
        return book;

    }
    @GetMapping("get")
    public List<book> getBooks(){
        return bookutils.getBook();
    }

    @GetMapping("get/{id}")
    public book getBooks(@PathVariable("id")Long id){
        return bookutils.GetBookById(id);
    }
    @DeleteMapping("{id}")
    public Boolean deleteBook(@PathVariable("id") long id){
        return bookutils.deleteBook(id);
    }
}
