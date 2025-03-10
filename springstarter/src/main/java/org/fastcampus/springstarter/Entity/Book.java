package org.fastcampus.springstarter.Entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;
import lombok.Builder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book { //VO,DTO

    @Id // primary key(기본 키)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String author;
    private int price;
    private int pages;


    private LocalDateTime createdAt; //camelcase
    /* class entity일 때는 camel case, db table로 볼때는 snake case */

}
