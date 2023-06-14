package uz.books.librarysystem.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer publicationYear;
    private Boolean availabilityStatus;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
}

