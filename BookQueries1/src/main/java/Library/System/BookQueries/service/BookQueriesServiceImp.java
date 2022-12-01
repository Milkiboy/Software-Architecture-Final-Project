package Library.System.BookQueries.service;



import Library.System.BookQueries.domain.BookQueries;
import Library.System.BookQueries.repository.BookQueriesRepo;
import Library.System.BookQueries.service.dtos.BookAdapter;
import Library.System.BookQueries.service.dtos.BookQueriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class BookQueriesServiceImp implements BookQueriesService {
    @Autowired
    BookQueriesRepo bookQueriesRepo;


    @Override
    public BookQueriesDto getBookByIsbn(long isbn) {
        BookQueries optionalBookQueries = bookQueriesRepo.findById(isbn).get();
        if (optionalBookQueries == null){
            System.out.println("Book not found!");
        }
        return BookAdapter.getBookDtoFromBook(optionalBookQueries);
    }

    @Override
    public Collection<BookQueriesDto> getBooks() {
        List<BookQueries> bookQueries = bookQueriesRepo.findAll();
        return BookAdapter.getBookDtoListFromBookList(bookQueries);
    }
}
