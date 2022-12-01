package Library.System.BookQueries.service.dtos;



import Library.System.BookQueries.domain.Reviews;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class BookQueriesDto {
    private long isbn;
    private String title;
    private String description;
    private String name;
    private List<Reviews> reviewsList = new ArrayList<>();

}
