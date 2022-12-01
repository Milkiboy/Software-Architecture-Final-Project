package Library.System.Reviews.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Book {
    private long isbn;
//    private String title;

}
