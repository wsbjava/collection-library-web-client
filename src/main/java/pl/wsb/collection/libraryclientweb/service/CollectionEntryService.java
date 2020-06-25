package pl.wsb.collection.libraryclientweb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.collection.libraryclientweb.model.CollectionEntry;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.repository.CollectionEntryRepository;
import pl.wsb.collection.libraryclientweb.repository.CollectionTypeRepository;

import java.text.Normalizer;

@Service
@Transactional
public class CollectionEntryService {

    private final CollectionEntryRepository collectionTypeRepository;

    public CollectionEntryService(CollectionEntryRepository collectionTypeRepository) {
        this.collectionTypeRepository = collectionTypeRepository;
    }

    public Iterable<CollectionEntry> listAll(){
        return this.collectionTypeRepository.findAll();
    }

    public void save(CollectionEntry genre){
        this.collectionTypeRepository.save(genre);
    }

    public CollectionEntry find(Integer id){
        return this.collectionTypeRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        this.collectionTypeRepository.deleteById(id);
    }

}
