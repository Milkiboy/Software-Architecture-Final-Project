package Library.System.Borrowings.service;




import Library.System.Borrowings.domain.Borrowings;
import Library.System.Borrowings.service.dtos.BorrowingsDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BorrowingsAdapter {
    public static Borrowings getBorrowingsFromBorrowingsDto(BorrowingsDto borrowingsDto){
        return new Borrowings(borrowingsDto.getBorrowingNumber(),
                borrowingsDto.getDate(),borrowingsDto.getCustomer(), borrowingsDto.getBook());
    }
    public static BorrowingsDto getBorrowingsDtoFromBorrowings(Borrowings borrowings){
        return  new BorrowingsDto(borrowings.getBorrowingNumber(),
                borrowings.getDate(), borrowings.getCustomer(),borrowings.getBook());
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
