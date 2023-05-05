package com.rapigrow.main.sec2;

import com.rapigrow.main.entities.Book;
import com.rapigrow.main.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ControllerBook {
    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public List<Book> getBooks() {

        System.out.println("Chal Gy kya");
        return this.bookService.getAllBooks();
    }
    @GetMapping("/books/{id}")
    public Book getBook( @PathVariable("id") int id){

        return bookService.getBookById(id);
    }
    @PostMapping("/books")
    public Book addbook(@RequestBody Book book){
       Book b= this.bookService.addBook(book);
        System.out.println(book);
        return b;
    }

    @PostMapping("bookswithresponse")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b=this.bookService.addBook(book);
        return ResponseEntity.ok(book);
    }
}
