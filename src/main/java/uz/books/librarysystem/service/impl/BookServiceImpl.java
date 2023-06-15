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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void save(BookDto book) {
        Integer id = book.getId();
        if(id == null) {
            Book item = new Book();
            item.setTitle(book.getTitle());
            item.setAuthor(author(book.getAuthor()));
            item.setGenre(genre(book.getGenre()));
            item.setPublicationYear(book.getPublicationYear());
            item.setAvailabilityStatus(book.getAvailabilityStatus());
            repository.save(item);
        }
        else{
            Book entity = repository.findById(id).get();
            entity.setTitle(book.getTitle());
            entity.setAuthor(author(book.getAuthor()));
            entity.setGenre(genre(book.getGenre()));
            entity.setPublicationYear(book.getPublicationYear());
            entity.setAvailabilityStatus(book.getAvailabilityStatus());
            repository.save(entity);
        }
    }

    public Author author(String name){
        List<Author> AuthorsList = authorRepository.findByName(name);
        if(!AuthorsList.isEmpty())
            return AuthorsList.get(0);
        else{
            Author author = new Author();
            author.setName(name);
            authorRepository.save(author);
            return author;
        }
    }
    public Genre genre(String name){
        List<Genre> genreList = genreRepository.findByName(name);
        if(!genreList.isEmpty())
            return genreList.get(0);
        else{
            Genre genre = new Genre();
            genre.setName(name);
            genreRepository.save(genre);
            return genre;
        }

    }


    @Override
    public void delete(Integer id) {
        Book entity = repository.findById(id).get();
        repository.delete(entity);
    }

    @Override
    public List<BookDto> findAllBook(){
        return dtoList(repository.findAll());
    }

    List<BookDto> dtoList (List<Book> booklist){
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : booklist){
            BookDto dto = new BookDto();
            dto.setId(book.getId());
            dto.setAuthor(book.getAuthor().getName());
            dto.setGenre(book.getGenre().getName());
            dto.setTitle(book.getTitle());
            dto.setAvailabilityStatus(book.getAvailabilityStatus());
            dto.setPublicationYear(book.getPublicationYear());
            bookDtos.add(dto);
        }
        return bookDtos;
    }
    @Override
    public List<BookDto> search(String keyword) {
        return dtoList(repository.search(keyword));
    }

    @Override
    public BookDto find(Integer id) {
        List<BookDto> allBooks = findAllBook();
        BookDto result = null;
        for(BookDto book : allBooks) {
            if (Objects.equals(book.getId(), id)) {
                result = book;
            }
        }
        return result;
    }

}
