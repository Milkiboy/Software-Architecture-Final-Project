package Library.System.BookQueries.service.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class ReviewsDto {
private long isbn;
private String reviewRating;
private String customerName;
private String description;

}
