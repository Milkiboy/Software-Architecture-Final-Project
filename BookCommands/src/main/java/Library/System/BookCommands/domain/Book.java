package Library.System.BookCommands.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Book {
    @Id
    private long isbn;
    private String title;
    private String description;
    private String name;
}
