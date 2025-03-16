package org.fastcampus.springstarter.Service;

import org.fastcampus.springstarter.Entity.Review;
import org.fastcampus.springstarter.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public Double reviewAvgRating(Long book_id){
       return reviewRepository.findAverageRatingByBookId(book_id);
    }

    public void deleteReviewById(Long review_id) {
        reviewRepository.deleteReviewById(review_id);
    }

}
