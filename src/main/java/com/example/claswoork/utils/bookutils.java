package com.example.claswoork.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.claswoork.models.book;
public class bookutils {
    public static bookutils instance;
    private List<book> book = new ArrayList<>();
    private bookutils(){}

    public synchronized static bookutils getInstance(){

        if(instance == null){
            instance = new bookutils();
        }
        return instance;
    }
    public void addbook(book book){
        this.book.add(book);
    }
    public List<book> getBook(){
        return book;
    }
    public book GetBookById(long id) {
        List<book> book1 = this.book
                .stream()
                .filter(b -> Objects.equals(b.getId(), id))
                .collect(Collectors.toList());
        if (!book1.isEmpty()) {
            return book1.get(0);

        }
        return null;
    }
    public boolean deleteBook(long id) {
        for (book b : book) {
            if (Objects.equals(b.getId(), id)) {
                return this.book.remove(b);
            }
        }
        return false;
    }

}
