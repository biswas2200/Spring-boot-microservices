package org.projectjobapp.jobapplication.service.impl;

import org.projectjobapp.jobapplication.dto.ReviewsDTO;
import org.projectjobapp.jobapplication.entity.Reviews;
import org.projectjobapp.jobapplication.repository.ReviewsRepository;
import org.projectjobapp.jobapplication.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImplementation implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewServiceImplementation(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public static ReviewsDTO mapToDTOReview(Reviews reviews) {
        if (reviews == null)
            return null;
        ReviewsDTO reviewsDTO = new ReviewsDTO();
        reviewsDTO.setReviewId(reviews.getReviewId());
        reviewsDTO.setName(reviews.getName());
        reviewsDTO.setDescription(reviews.getDescription());
        reviewsDTO.setRating(reviews.getRating());
        reviewsDTO.setCompany(reviews.getCompany());

        return reviewsDTO;
    }

    public static Reviews mapToEntityReview(ReviewsDTO reviewsDTO) {
        if (reviewsDTO == null)
            return null;

        Reviews reviews = new Reviews();
        reviews.setReviewId(reviewsDTO.getReviewId());
        reviews.setName(reviewsDTO.getName());
        reviews.setDescription(reviewsDTO.getDescription());
        reviews.setRating(reviewsDTO.getRating());
        reviews.setCompany(reviewsDTO.getCompany());

        return reviews;
    }

    @Override
    public List<ReviewsDTO> getAllReviews() {
        List<Reviews> reviewsList = reviewsRepository.findAll();
        return reviewsList.stream()
                .map(ReviewServiceImplementation::mapToDTOReview)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewsDTO getReviewsById(Long reviewsId) {
        Optional <Reviews> reviews = reviewsRepository.findById(reviewsId);
        return reviews.map(ReviewServiceImplementation ::mapToDTOReview)
                .orElse(null);
    }

    @Override
    public ReviewsDTO createReviews(ReviewsDTO reviewsDTO) {
        Reviews reviews = mapToEntityReview(reviewsDTO);
        Reviews saveReviews = reviewsRepository.save(reviews);
        return mapToDTOReview(saveReviews);
    }

    @Override
    public ReviewsDTO updateReviews(Long reviewId, ReviewsDTO reviewsDTO) {
        Reviews existingReview = reviewsRepository.findById(reviewId).orElse(null);
        if(existingReview != null){
            existingReview.setName(reviewsDTO.getName());
            existingReview.setDescription(reviewsDTO.getDescription());
            existingReview.setRating(reviewsDTO.getRating());
            existingReview.setCompany(reviewsDTO.getCompany());
            Reviews updateReviews = reviewsRepository.save(existingReview);
            return mapToDTOReview(updateReviews);
        }
        return null;
    }

    @Override
    public void deleteReviews(Long reviewsId) {
        reviewsRepository.deleteById(reviewsId);
    }
}
