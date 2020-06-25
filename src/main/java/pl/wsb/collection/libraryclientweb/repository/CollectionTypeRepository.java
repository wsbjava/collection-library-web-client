package pl.wsb.collection.libraryclientweb.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.model.Genre;

public interface CollectionTypeRepository extends CrudRepository<CollectionType, Integer> {
}
