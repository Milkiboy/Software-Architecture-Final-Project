package Library.System.BookQueries.web;



import Library.System.BookQueries.service.BookQueriesService;
import Library.System.BookQueries.service.dtos.BookQueriesDto;
import Library.System.BookQueries.service.dtos.BooksQueriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookQ")
public class BookQueriesController {
    @Autowired
    BookQueriesService bookQueriesService;

    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable long isbn){
       BookQueriesDto bookDto= bookQueriesService.getBookByIsbn(isbn);
        return  new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getBooks(){
        Collection<BookQueriesDto> bookDtos= bookQueriesService.getBooks();
        BooksQueriesDto booksDto=new BooksQueriesDto(bookDtos);
        return new ResponseEntity<>(booksDto, HttpStatus.OK);
    }

}
