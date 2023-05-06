package com.rapigrow.main.entities;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//import org.hibernate.dialect.MySQL8Dialect;
//import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
//@Entity
//@Table(name ="books")

public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "book_id")
    private int id;
    private String title;

    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
