package Library.System.Reviews.service;


import Library.System.Reviews.domain.Review;
import Library.System.Reviews.repo.ReviewRepo;
import Library.System.Reviews.service.dtos.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;
    @Override
    public void add(ReviewDto reviewDto) {
       Review review = ReviewAdapter.getReviewFromReviewDto(reviewDto);
        reviewRepo.save(review);
    }

}
