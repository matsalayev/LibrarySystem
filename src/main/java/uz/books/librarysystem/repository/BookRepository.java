package uz.books.librarysystem.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.*;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
select  new uz.books.librarysystem.dtos.BookDto(b.id, b.title, a.name,  g.name, b.publicationYear, b.availabilityStatus)
 from Book b inner join Author a on a.id = b.authorId inner join Genre g on g.id = b.genreId
""")
    List<BookDto> findAllBook();
}