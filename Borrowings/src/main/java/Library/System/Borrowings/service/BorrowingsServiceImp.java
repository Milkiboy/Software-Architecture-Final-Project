package Library.System.Borrowings.service;



import Library.System.Borrowings.domain.Borrowings;
import Library.System.Borrowings.repo.BorrowingRepo;
import Library.System.Borrowings.service.dtos.BorrowingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
public class BorrowingsServiceImp implements BorrowingsService {
    @Autowired
    BorrowingRepo borrowingRepo;
    @Override
    public void add(BorrowingsDto borrowingsDto) {
       Borrowings borrowings = BorrowingsAdapter.getBorrowingsFromBorrowingsDto(borrowingsDto);
        borrowingRepo.save(borrowings);
    }

    @Override
    public void deleteByBorrowingNumber(long borrowingNumber) {

        borrowingRepo.deleteById(borrowingNumber);
    }

    @Override
    public void updateByBorrowingNumber(long borrowingNumber, BorrowingsDto borrowingsDto) {
        Optional<Borrowings> optionalBorrowings= borrowingRepo.findById(borrowingNumber);
        if (optionalBorrowings.isPresent()){
            Borrowings borrowings=BorrowingsAdapter.getBorrowingsFromBorrowingsDto(borrowingsDto);
            borrowingRepo.save(borrowings);
        }
    }
//    @Override
//    public void updateCustomer(CustomerDto customerDto) {
//        var borrowing= borrowingRepository.findAllByCustomer_CustomerNumber(customerDto.getCustomerDto().getCustomerNumber());
//        if(borrowing==null){
//            throw new NullPointerException("Borrowing not found");
//        }
//
//        borrowing.stream().map(n->{
//                    var customer= new Customer(customerEvent.getCustomerDto().getCustomerNumber(),
//                            customerEvent.getCustomerDto().getName());
//                    n.setCustomer(customer);
//                    return n;
//                }
//        ).collect(Collectors.toList());
//
//        borrowing.stream().map(n->borrowingRepository.save(n));
//
//    }

    public BorrowingsDto getBorrowingsByBorrowingNumber(long borrowingNumber) {

        Borrowings optionalBorrowings= borrowingRepo.findById(borrowingNumber).get();
        if (optionalBorrowings == null){
            System.out.println("Nothing is Borrowed!");
        }

        return BorrowingsAdapter.getBorrowingsDtoFromBorrowings(optionalBorrowings);
    }

}
