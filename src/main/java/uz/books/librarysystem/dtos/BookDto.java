package uz.books.librarysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String title;
    private Integer publicationYear;
    private Boolean availabilityStatus;
    private String author;
    private String genre;
}
