package Library.System.BookCommands.web;


import Library.System.BookCommands.service.BookService;
import Library.System.BookCommands.service.dtos.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        bookService.add(bookDto);
        return  new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable long isbn){
        bookService.deleteByIsbn(isbn);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable long isbn,@RequestBody BookDto bookDto){
        bookService.updateByIsbn(isbn,bookDto);
        return  new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

}
