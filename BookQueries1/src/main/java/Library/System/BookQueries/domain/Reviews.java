package Library.System.BookQueries.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Reviews {
private long isbn;
private String reviewRating;
private String customerName;
private String description;

}
