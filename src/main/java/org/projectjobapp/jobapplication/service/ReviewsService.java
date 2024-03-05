package org.projectjobapp.jobapplication.service;

import org.projectjobapp.jobapplication.dto.ReviewsDTO;

import java.util.List;

public interface ReviewsService {
    List<ReviewsDTO> getAllReviews();

    ReviewsDTO getReviewsById(Long reviewsId);


}
