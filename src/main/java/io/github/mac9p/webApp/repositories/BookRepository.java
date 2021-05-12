package io.github.mac9p.webApp.repositories;

import io.github.mac9p.webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
