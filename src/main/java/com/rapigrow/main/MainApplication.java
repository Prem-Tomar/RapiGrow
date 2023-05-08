package com.rapigrow.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);
//
//			UserRepository bookrepo=context.getBean(UserRepository.class);
//			Book book=new Book();
//			book.setId(123);
//			book.setAuthor("DKT");
//			book.setTitle("The My book");
//
//			Book book1 = bookrepo.save(book);
//		System.out.println(book1);


    }


}
