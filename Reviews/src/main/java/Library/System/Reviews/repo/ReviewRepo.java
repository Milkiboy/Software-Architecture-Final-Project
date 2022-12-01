package Library.System.Reviews.repo;




import Library.System.Reviews.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Review,Long> {

}
