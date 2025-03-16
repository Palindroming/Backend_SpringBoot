package org.fastcampus.springstarter.controller;

import org.fastcampus.springstarter.Entity.Review;
import org.fastcampus.springstarter.Service.ReviewService;
import org.springframework.ui.Model;
import org.fastcampus.springstarter.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.fastcampus.springstarter.Entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        //books -> 번지값
        model.addAttribute("books",books);
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String getDetails(@PathVariable Long id, Model model){
        Optional<Book> bookOptional = bookService.getById(id);
        if(bookOptional.isPresent()){
           Book book = bookOptional.get(); //review정보도 담겨있다.
            model.addAttribute("book",book);


//            double averageRating = book.getReviews().stream().mapToDouble(r -> r.getRating()).average().getAsDouble();
//            model.addAttribute("averageRating",averageRating);
            Double averageRating = reviewService.reviewAvgRating(id);
            if(averageRating!=null){
                model.addAttribute("averageRating",averageRating.intValue());

            } else{
                model.addAttribute("averageRating","평점이 없습니다.");
            }
           return "detail"; //상세보기 view(detail.html) : ${book}
        }else{
            return "redirect:/";
        }
    }


    @PostMapping("/register")
    public String reviewRegister(@RequestParam("book_id")Long book_id, Review review) {
        Book book = bookService.getById(book_id).orElseThrow(() -> new IllegalArgumentException("invalid bookd id" + book_id));

        review.setBook(book);
        review.setCreatedAt(LocalDateTime.now());
        reviewService.save(review); // 등록 성공
        return "redirect:/detail/" + book.getId();
    }


    @PostMapping("/deleteReview")
    public String DeleteReview(Long review_id, Long book_id, RedirectAttributes redirectAttributes) {
        reviewService.deleteReviewById(review_id);
        redirectAttributes.addFlashAttribute("message", "리뷰가 삭제되었습니다");

        return "redirect:/detail/" + book_id;
    }





}
