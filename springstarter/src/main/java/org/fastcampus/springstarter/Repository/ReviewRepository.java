package org.fastcampus.springstarter.Repository;

import jakarta.transaction.Transactional;
import org.fastcampus.springstarter.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
@Query("SELECT avg(r.rating) from Review r where r.book.id =:book_id")
    Double findAverageRatingByBookId(@Param("book_id")Long book_id);

@Transactional
  public void deleteReviewById(Long reviewId);

}
