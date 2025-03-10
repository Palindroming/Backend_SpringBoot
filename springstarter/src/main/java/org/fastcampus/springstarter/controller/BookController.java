package org.fastcampus.springstarter.controller;

import org.springframework.ui.Model;
import org.fastcampus.springstarter.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.fastcampus.springstarter.Entity.Book;

import java.util.List;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        //books -> 번지값
        model.addAttribute("books",books);
        return "home";
    }


}
