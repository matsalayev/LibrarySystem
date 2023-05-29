package uz.books.librarysystem.service.impl;

import org.springframework.stereotype.Service;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Author;
import uz.books.librarysystem.model.Book;
import uz.books.librarysystem.model.Genre;
import uz.books.librarysystem.repository.AuthorRepository;
import uz.books.librarysystem.repository.BookRepository;
import uz.books.librarysystem.repository.GenreRepository;
import uz.books.librarysystem.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book update(Integer id, BookDto item) {
        Book entity = repository.findById(id).get();
        entity.setTitle(item.getTitle());
        entity.setAuthorId(authorId(item.getAuthor()));
        entity.setGenreId(genreId(item.getGenre()));
        entity.setPublicationYear(item.getPublicationYear());
        entity.setAvailabilityStatus(item.getAvailabilityStatus());
        repository.save(entity);
        return entity;
    }

    public Integer authorId(String name){
        List<Author> author = authorRepository.findByName(name);
        if((long) author.size() > 0){
            return author.get(0).getId();
        }
        else{
            Author newAuthor = new Author();
            newAuthor.setName(name);
            authorRepository.save(newAuthor);
            return newAuthor.getId();
        }
    }

    public Integer genreId(String name){
        List<Genre> genre = genreRepository.findByName(name);
        if((long) genre.size() > 0){
            return genre.get(0).getId();
        }
        else{
            Genre newGenre = new Genre();
            newGenre.setName(name);
            genreRepository.save(newGenre);
            return newGenre.getId();
        }
    }

    @Override
    public Book create(BookDto book) {
        Book item = new Book();
        item.setTitle(book.getTitle());
        item.setAuthorId(authorId(book.getAuthor()));
        item.setGenreId(genreId(book.getGenre()));
        item.setPublicationYear(book.getPublicationYear());
        item.setAvailabilityStatus(book.getAvailabilityStatus());
        repository.save(item);
        return item;
    }

    @Override
    public String delete(Integer id) {
        Book entity = repository.findById(id).get();
        String name = entity.getTitle();
        repository.delete(entity);
        return name + " ba'zadan o'chirildi";
    }

    @Override
    public List<BookDto> findAllBook(){
        return repository.findAllBook();
    }

}
