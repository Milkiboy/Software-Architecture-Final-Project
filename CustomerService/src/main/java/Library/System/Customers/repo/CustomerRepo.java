package Library.System.Customers.repo;


import Library.System.Customers.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,Long> {
//   Customer findById(long customerNumber);

}
