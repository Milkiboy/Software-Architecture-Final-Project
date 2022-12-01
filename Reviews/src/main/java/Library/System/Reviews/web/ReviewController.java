package Library.System.Reviews.web;



;
import Library.System.Reviews.service.ReviewService;
import Library.System.Reviews.service.dtos.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto){
        reviewService.add(reviewDto);
        return  new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }




}
