package uz.books.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.books.librarysystem.model.*;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("select e from Author e where e.name = :name")
    List<Author> findByName(@Param("name") String name);
}
