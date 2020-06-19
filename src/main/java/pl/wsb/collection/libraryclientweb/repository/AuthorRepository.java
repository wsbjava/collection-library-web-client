package pl.wsb.collection.libraryclientweb.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.collection.libraryclientweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
