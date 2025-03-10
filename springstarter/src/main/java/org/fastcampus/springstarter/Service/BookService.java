package org.fastcampus.springstarter.Service;

import lombok.AllArgsConstructor;
import org.fastcampus.springstarter.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.fastcampus.springstarter.Entity.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor //생성자 주입
public class BookService {

    private final BookRepository bookRepository;

    List<Book> bookList = new ArrayList<>();

   public Book save(Book book) { //insert or update
       if(book.getId() == null) {
           book.setCreatedAt(LocalDateTime.now());
       } return bookRepository.save(book); // insert, update
   }


    public Optional<Book> getById(long id) {

       return Optional.ofNullable(bookRepository.findById(id));
    }


    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }




}

/*
CRUD
C,U - save
r - read
 */