package Library.System.Borrowings.service;





import Library.System.Borrowings.service.dtos.BorrowingsDto;

import java.util.Collection;

public interface BorrowingsService {
    void  add(BorrowingsDto borrowingsDto);
    void deleteByBorrowingNumber(long borrowingNumber);
    void updateByBorrowingNumber(long borrowingNumber,BorrowingsDto borrowingsDto);

    BorrowingsDto getBorrowingsByBorrowingNumber (long borrowingNumber);
//    public void updateCustomer(CustomerDto customerDto);

//     Collection<BorrowingsDto> getBorrowings();

}