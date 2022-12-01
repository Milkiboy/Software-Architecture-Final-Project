package Library.System.BookCommands.service.dtos;



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
    private String description;
    private String name;
}
