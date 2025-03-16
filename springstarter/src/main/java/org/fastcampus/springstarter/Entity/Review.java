package org.fastcampus.springstarter.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //리뷰, 일련번호
    private String content; //리뷰 내용
    private int rating;// 평점(1~5)
    private LocalDateTime createdAt;

    @ManyToOne
    //foreign key가 book을 가리킨다.
    @JoinColumn(name = "book_id", referencedColumnName = "id",nullable = false)
    private Book book; //book: id(PK)

}
