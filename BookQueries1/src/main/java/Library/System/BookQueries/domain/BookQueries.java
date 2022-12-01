package Library.System.BookQueries.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class BookQueries {
    @Id
    private long isbn;
    private String title;
    private String description;
    private String name;
    List<Reviews> reviewsList = new ArrayList<>();
}
