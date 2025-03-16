package org.fastcampus.springstarter.Entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews; //book테이블이 만들어 질 떄 column으로 만들 수 없다.

}
