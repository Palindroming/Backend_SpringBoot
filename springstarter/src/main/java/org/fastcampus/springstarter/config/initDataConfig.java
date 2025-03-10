package org.fastcampus.springstarter.config;

import org.fastcampus.springstarter.Entity.Book;
import org.fastcampus.springstarter.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class initDataConfig implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = bookService.getAll();

        if(books.size()==0){
            bookService.save(
                    Book.builder()  // ✅ 클래스 이름 사용
                            .price(30000)
                            .subject("JAVA")
                            .author("kimkildong")
                            .pages(600)
                            .build()
            );
             bookService.save(
                    Book.builder()  // ✅ 클래스 이름 사용
                            .price(37000)
                            .subject("PYTHON")
                            .author("NAKILDONG")
                            .pages(800)
                            .build()
            );



        }
    }
}
