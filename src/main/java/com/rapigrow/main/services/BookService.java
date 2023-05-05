package com.rapigrow.main.services;

import com.rapigrow.main.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(1,"Java Complete reference","prem Kumar Tiwari"));
        list.add(new Book(12,"Java My World","prem "));
        list.add(new Book(14,"The World Wide Web","Mr. Bansi LAl"));
    }

    public List<Book> getAllBooks(){
        return list;
    }

    //get single book by id

    public Book getBookById(int id){
        Book book=null;
      book=  list.stream().filter(e->e.getId()==id).findFirst().get();
      return book;
    }

    public Book addBook(Book b){
        list.add(b);
        return b;
    }
}
