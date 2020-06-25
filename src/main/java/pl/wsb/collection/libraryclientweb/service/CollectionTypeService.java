package pl.wsb.collection.libraryclientweb.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.repository.CollectionTypeRepository;
import pl.wsb.collection.libraryclientweb.repository.GenreRepository;

import java.text.Normalizer;

@Service
@Transactional
public class CollectionTypeService {

    private final CollectionTypeRepository collectionTypeRepository;
    public CollectionTypeService(CollectionTypeRepository collectionTypeRepository){
        this.collectionTypeRepository = collectionTypeRepository;
    }

    public Iterable<CollectionType> listAll(){
        return this.collectionTypeRepository.findAll();
    }

    public void save(CollectionType genre){
        this.collectionTypeRepository.save(genre);
    }

    public CollectionType find(Integer id){
        return this.collectionTypeRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        this.collectionTypeRepository.deleteById(id);
    }

    public String generateAbbr(String name){
        return Normalizer.normalize(name, Normalizer.Form.NFKD);
    }
}
