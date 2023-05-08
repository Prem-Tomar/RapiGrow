package com.rapigrow.main.services;

import com.rapigrow.main.entities.Book;

import java.util.List;

public interface BookServiceInterface {


    public List<Book>   getAllBooks();

    //get single book by id

    public Book getBookById(int id);

    public Book addBook(Book b);


    public void deleteBook(int bid);


    public void updateBook(Book book, int bookId);
}
