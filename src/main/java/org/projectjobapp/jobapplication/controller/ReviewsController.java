package org.projectjobapp.jobapplication.controller;


import org.projectjobapp.jobapplication.dto.ReviewsDTO;
import org.projectjobapp.jobapplication.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company/get/reviews")
@RestController
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping("/get")
    ResponseEntity<List<ReviewsDTO>> getAllReviews() {
        List<ReviewsDTO> reviewsDTOS = reviewsService.getAllReviews();
        return new ResponseEntity<>(reviewsDTOS, HttpStatus.OK);
    }

    @GetMapping("/get/{reviewId}")
    ResponseEntity<ReviewsDTO> getReviewById(@PathVariable Long reviewId) {
        ReviewsDTO reviewsDTO = reviewsService.getReviewsById(reviewId);
        return reviewsDTO != null ? new ResponseEntity<>(reviewsDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    ResponseEntity<ReviewsDTO> createReview(@RequestBody ReviewsDTO reviewsDTO) {
        ReviewsDTO dto = reviewsService.createReviews(reviewsDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/up/{reviewId}")
    ResponseEntity<ReviewsDTO> updateReview(@PathVariable Long reviewId,
                                            @RequestBody ReviewsDTO reviewsDTO) {
        ReviewsDTO dto = reviewsService.updateReviews(reviewId, reviewsDTO);
        return dto != null ? new ResponseEntity<>(dto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/get/{reviewId}")
    ResponseEntity<ReviewsDTO> deleteReview(@PathVariable Long reviewId) {
        reviewsService.deleteReviews(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
