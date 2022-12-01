package Library.System.Reviews.service;


import Library.System.Reviews.domain.Review;
import Library.System.Reviews.service.dtos.ReviewDto;

public class ReviewAdapter {
    public static Review getReviewFromReviewDto(ReviewDto reviewDto){
        return new Review(reviewDto.getReviewId(), reviewDto.getBook(),reviewDto.getReviewRating(),
                reviewDto.getCustomer(), reviewDto.getDescription());
    }
    public static ReviewDto getBorrowingsDtoFromBorrowings(Review review){
        return  new ReviewDto(review.getReviewId(),
                review.getBook(), review.getReviewRating(), review.getCustomer(),review.getDescription());
    }
//    public static Collection<BorrowingsDto> getBorrowingsDtoListFromBookList(List<Borrowings> borrowingsList){
//        List <BorrowingsDto> borrowingsDtos =new ArrayList<>();
//        for (Borrowings borrowings1:borrowingsList){
//            borrowingsDtos.add(getBorrowingsDtoFromBorrowings(borrowings1));
//
//        }
//        return borrowingsDtos;
//    }
}
