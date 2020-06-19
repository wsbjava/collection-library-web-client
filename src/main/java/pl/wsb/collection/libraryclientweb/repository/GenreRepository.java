package pl.wsb.collection.libraryclientweb.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.collection.libraryclientweb.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
