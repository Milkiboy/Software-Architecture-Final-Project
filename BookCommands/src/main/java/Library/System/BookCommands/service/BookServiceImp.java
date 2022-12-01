package Library.System.BookCommands.service;


import Library.System.BookCommands.domain.Book;
import Library.System.BookCommands.kafka.Sender;
import Library.System.BookCommands.repo.BookRepo;
import Library.System.BookCommands.service.dtos.BookAdapter;
import Library.System.BookCommands.service.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    Sender sender;

    @Override
    public void add(BookDto bookDto) {
        Book book= BookAdapter.getBookFromBookDto(bookDto);
        bookRepo.save(book);
        sender.send("book_topic", bookDto);
    }

//    @Override
//    public void deleteByIsbn(long isbn) {
//        Book book = bookRepo.findById(isbn).get();
//      bookRepo.delete(book);
//    }
    @Override
    public void deleteByIsbn(long isbn) {
        bookRepo.deleteByIsbn(isbn);
    }

    @Override
    public void updateByIsbn(long isbn, BookDto bookDto) {
        Optional<Book> optionalBook= bookRepo.findById(isbn);
        if (optionalBook.isPresent()){
            Book book=BookAdapter.getBookFromBookDto(bookDto);
            bookRepo.save(book);
            sender.send("book_topic", bookDto);
        }
    }

//    @Override
//    public void updateByIsbn(long isbn, BookDto bookDto) {
//        Book book = bookRepo.findById(isbn);
//        book.setIsbn(bookDto.getIsbn());
//        book.setTitle(bookDto.getTitle());
//        book.setDescription(bookDto.getDescription());
//        book.setName(bookDto.getName());
//
//
//
//        bookRepo.save(book);
//    }

}
