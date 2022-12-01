package Library.System.BookQueries.service.dtos;



import Library.System.BookQueries.domain.BookQueries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookAdapter {



    public static BookQueriesDto getBookDtoFromBook(BookQueries bookQueries){
        return  new BookQueriesDto(bookQueries.getIsbn(),
                bookQueries.getTitle(), bookQueries.getDescription(), bookQueries.getName(),bookQueries.getReviewsList());
    }
    public static BookQueries getBookFromBookDto(BookQueriesDto bookQueriesDto){
        return new BookQueries(bookQueriesDto.getIsbn(),
                bookQueriesDto.getTitle(), bookQueriesDto.getDescription(), bookQueriesDto.getName(),bookQueriesDto.getReviewsList());
    }

    public static Collection<BookQueriesDto> getBookDtoListFromBookList(List<BookQueries> bookQueries){
        List <BookQueriesDto> bookQueriesDtos =new ArrayList<>();
        for (BookQueries booksQueries : bookQueries){
            bookQueriesDtos.add(getBookDtoFromBook(booksQueries));

        }
        return bookQueriesDtos;
    }
}
