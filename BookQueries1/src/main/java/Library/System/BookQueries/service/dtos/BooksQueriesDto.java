package Library.System.BookQueries.service.dtos;

import lombok.*;


import java.util.ArrayList;
import java.util.Collection;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@ToString
public class BooksQueriesDto {
    private Collection<BookQueriesDto> bookQueriesDtos = new ArrayList<>();
}
