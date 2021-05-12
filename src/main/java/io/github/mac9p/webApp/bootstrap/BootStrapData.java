package io.github.mac9p.webApp.bootstrap;

import io.github.mac9p.webApp.domain.Author;
import io.github.mac9p.webApp.domain.Book;
import io.github.mac9p.webApp.domain.Publisher;
import io.github.mac9p.webApp.repositories.AuthorRepository;
import io.github.mac9p.webApp.repositories.BookRepository;
import io.github.mac9p.webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("eric", "Jenkins");
        Book someBook = new Book("some book", "13234");
        eric.getBooks().add(someBook);
        someBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(someBook);

        Author drak = new Author("Drak", "Rogers");
        Book anotherBook = new Book("another book", "234545");
        drak.getBooks().add(anotherBook);
        anotherBook.getAuthors().add(drak);

        authorRepository.save(drak);
        bookRepository.save(anotherBook);

        Publisher bookerComp = new Publisher("booker camp", "Jazdowa",
                "Lublin", "Lubelskie", "22-352");
        publisherRepository.save(bookerComp);

        someBook.setPublisher(bookerComp);
        bookerComp.getBooks().add(someBook);
        anotherBook.setPublisher(bookerComp);
        bookerComp.getBooks().add(anotherBook);
        publisherRepository.save(bookerComp);

        System.out.println("started in bootstrap");
        System.out.println("number of books: " + bookRepository.count());
        System.out.println("number of publishers: "+ publisherRepository.count());
        System.out.println("publisher number of books: "+ bookerComp.getBooks().size());
    }
}
