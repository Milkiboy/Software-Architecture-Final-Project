package Library.System.BookQueries.service;




import Library.System.BookQueries.service.dtos.BookQueriesDto;

import java.util.Collection;

public interface BookQueriesService {
    public BookQueriesDto getBookByIsbn(long isbn);
    Collection<BookQueriesDto> getBooks();


}