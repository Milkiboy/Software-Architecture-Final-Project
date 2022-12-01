package Library.System.Borrowings.kafka;

import Library.System.Borrowings.domain.Book;
import Library.System.Borrowings.domain.Borrowings;
import Library.System.Borrowings.repo.BorrowingRepo;
import Library.System.Borrowings.service.BorrowingsService;
import Library.System.Borrowings.service.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BookReciver {

    @Autowired
    private BorrowingRepo borrowingRepo;

    @Autowired
    private BorrowingsService borrowingsService;



    @KafkaListener(id= "borrowingListener1",topics = {"book_topic"})
    public void receive(@Payload BookDto bookDto) {
        System.out.println("Recieved .. "+ bookDto);
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle());
        Borrowings o = borrowingRepo.findBookByIsbn(bookDto.getIsbn());
        o.getBook().setTitle(book.getTitle());
        borrowingRepo.save(o);
    }
}
