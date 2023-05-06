package com.rapigrow.main.services;

import com.rapigrow.main.entities.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookServiceInterface{
//    @Override
//    public List<Book> getAllBooks() {
//        return null;
//    }
//
//    @Override
//    public Book getBookById(int id) {
//        return null;
//    }
//
//    @Override
//    public Book addBook(Book b) {
//        return null;
//    }
//
//    @Override
//    public void deleteBook(int bid) {
//
//    }
//
//    @Override
//    public void updateBook(Book book, int bookId) {
//
//    }
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

    public void deleteBook(int bookId) {


            for(Book e:list){
                int x=e.getId();
                if(x==bookId){
                   list.remove(e);
                }

            }
        }


//    public void deleteBook(int bid){
//
//      list=  list.stream().filter(book->{
//            if(book.getId()!=bid){
//                return true;
//            }else
//                return false;
//        }).collect(Collectors.toList());
//    }


    public void updateBook(Book book,int bookId) {

      list=  list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
