package org.fastcampus.springstarter.config;

import org.fastcampus.springstarter.Entity.Book;
import org.fastcampus.springstarter.Entity.Review;
import org.fastcampus.springstarter.Service.BookService;
import org.fastcampus.springstarter.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class initDataConfig implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = bookService.getAll();

        if(books.size()==0){

             Book book1=      Book.builder()
                            .price(30000)
                            .subject("JAVA")
                            .author("kimkildong")
                            .pages(600)
                            .build();
           Book book2 =      Book.builder()
                            .price(37000)
                            .subject("PYTHON")
                            .author("NAKILDONG")
                            .pages(800)
                            .build();

           bookService.save(book1);
           bookService.save(book2);

        Review review1_1 =      Review.builder()
                    .content("easy and kind")
                    .rating(4)
                    .createdAt(LocalDateTime.now())
                    .book(book1)
                    .build();

        Review review2_1 =     Review.builder()
                    .content("그림으로 이해하기 쉽게 설명해줘요.")
                    .rating(4)
                    .createdAt(LocalDateTime.now())
                    .book(book2)
                    .build();
        Review review2_2 =     Review.builder()
                    .content("아주 재밌네요")
                    .rating(5)
                    .createdAt(LocalDateTime.now())
                    .book(book2)
                    .build();

            reviewService.save(review1_1);
            reviewService.save(review2_1);
            reviewService.save(review2_2);



        }
    }
}
