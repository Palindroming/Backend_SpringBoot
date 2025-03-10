package org.fastcampus.springstarter.Repository;

import org.fastcampus.springstarter.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
        //직접 메서들를 만들 수도 있다.
        // 기본적으로 JPARepository에서 제공해주는 메서드를 사용하는 방법

    public Book findById(long id);

}
