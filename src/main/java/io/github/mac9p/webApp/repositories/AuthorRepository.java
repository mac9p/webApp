package io.github.mac9p.webApp.repositories;

import io.github.mac9p.webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
