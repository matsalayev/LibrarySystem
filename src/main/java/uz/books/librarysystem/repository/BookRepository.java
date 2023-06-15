package uz.books.librarysystem.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.*;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select e from Book e where e.title like %:name%")
    List<Book> search(@Param("name") String name);
}