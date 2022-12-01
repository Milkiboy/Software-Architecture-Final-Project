package Library.System.Borrowings.repo;



import Library.System.Borrowings.domain.Borrowings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepo extends MongoRepository<Borrowings,Long> {

    @Query("{'customer.customerNumber'::#{#customerNumber}}")
    List<Borrowings> findCustomerByCustomerNumber(@Param("customerNumber") long customerNumber);

    @Query("{'book':{$elemMatch:{'isbn'::#{#isbn}}}}")
    Borrowings findBookByIsbn(@Param("isbn") long isbn);
}
