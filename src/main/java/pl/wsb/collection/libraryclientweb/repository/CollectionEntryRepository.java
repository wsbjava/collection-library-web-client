package pl.wsb.collection.libraryclientweb.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.collection.libraryclientweb.model.CollectionEntry;

public interface CollectionEntryRepository extends CrudRepository<CollectionEntry, Integer> {

}
