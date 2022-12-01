package Library.System.BookQueries.repository;



import Library.System.BookQueries.domain.BookQueries;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueriesRepo extends MongoRepository<BookQueries,Long> {
//    Book findById(long isbn);
}
