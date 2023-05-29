package uz.books.librarysystem.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private Integer id;
    private String title;
    private Integer publicationYear;
    private Boolean availabilityStatus;
    private String author;
    private String genre;
    public BookDto(Integer id, String title,String author, String genre, Integer publicationYear, Boolean availabilityStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.availabilityStatus = availabilityStatus;
    }
}
