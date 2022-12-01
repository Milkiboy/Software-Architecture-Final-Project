package Library.System.BookQueries.kafka;


import Library.System.BookQueries.repository.BookQueriesRepo;
import Library.System.BookQueries.service.dtos.BookAdapter;
import Library.System.BookQueries.service.dtos.BookQueriesDto;
import Library.System.BookQueries.service.dtos.BooksQueriesDto;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    BookQueriesRepo bookQueriesRepo;

    @KafkaListener(id= "bookListener", topics={"book_topic1"})
    public void receive(@Payload BookQueriesDto bookQueriesDto ) {
        System.out.println("message received: " + bookQueriesDto);
        bookQueriesRepo.save(BookAdapter.getBookFromBookDto(bookQueriesDto));
    }
//    @KafkaListener(topics = "addtopic", groupId = "gid2")
//    public void receive(@Payload BookDTO bookDTO,
//                        @Headers MessageHeaders headers) {
//        System.out.println("received message="+ bookDTO.toString());
//    }

//    @KafkaListener(topics={"review_topic"})
//    public void receive(@Payload ReviewsDto reviewsDto ) {
//        System.out.println("message received: " + reviewsDto);
//        bookQueriesRepo.save(BookAdapter.getBookFromBookDto(bookQueriesDto));
//    }

}
