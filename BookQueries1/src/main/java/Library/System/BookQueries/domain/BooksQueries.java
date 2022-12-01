package Library.System.BookQueries.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BooksQueries {
    private Collection<BookQueries> customers =new ArrayList<>();
}

