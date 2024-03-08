package org.projectjobapp.jobapplication.service;

import org.projectjobapp.jobapplication.dto.ReviewsDTO;

import java.util.List;

public interface ReviewsService {
    List<ReviewsDTO> getAllReviews();

    ReviewsDTO getReviewsById(Long reviewsId);

    ReviewsDTO createReviews(ReviewsDTO reviewsDTO);

    ReviewsDTO updateReviews(Long reviewId, ReviewsDTO reviewsDTO);

    void deleteReviews(Long reviewsId);
}
