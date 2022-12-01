package Library.System.BookCommands.repo;


import Library.System.BookCommands.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book,Long> {
    void deleteByIsbn(long isbn);
//    Book findById(long isbn);
}
