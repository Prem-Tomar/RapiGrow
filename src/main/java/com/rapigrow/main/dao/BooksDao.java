package com.rapigrow.main.dao;

import com.rapigrow.main.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksDao extends JpaRepository<Book,Integer> {

}
