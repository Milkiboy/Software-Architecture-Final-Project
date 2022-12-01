package Library.System.BookCommands.service;



import Library.System.BookCommands.service.dtos.BookDto;

import java.util.Collection;

public interface BookService {
    void  add(BookDto bookDto);
    void deleteByIsbn(long isbn);
    void updateByIsbn(long isbn,BookDto bookDto);

}