package Library.System.BookCommands.service.dtos;


import Library.System.BookCommands.domain.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookAdapter {
    public static Book getBookFromBookDto(BookDto bookDto){
        return new Book(bookDto.getIsbn(),
                bookDto.getTitle(), bookDto.getDescription(), bookDto.getName());
    }
    public static BookDto getBookDtoFromBook(Book book){
        return  new BookDto(book.getIsbn(),
                book.getTitle(), book.getDescription(),book.getName());
    }

}
