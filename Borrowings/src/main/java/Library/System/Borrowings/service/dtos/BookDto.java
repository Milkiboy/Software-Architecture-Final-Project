package Library.System.Borrowings.service.dtos;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class BookDto {
    private long isbn;
    private String title;

}
