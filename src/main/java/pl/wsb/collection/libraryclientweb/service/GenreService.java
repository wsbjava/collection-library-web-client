package pl.wsb.collection.libraryclientweb.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.model.GenreCollectionType;
import pl.wsb.collection.libraryclientweb.repository.GenreRepository;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Iterable<Genre> listAll(){
        return this.genreRepository.findAll();
    }

    public void save(Genre genre){
        this.genreRepository.save(genre);
    }

    public Genre find(Integer id){
        return this.genreRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        this.genreRepository.deleteById(id);
    }

    public String generateAbbr(String name){
        return Normalizer.normalize(name, Normalizer.Form.NFKD);
    }
    public Iterable<CollectionType> getCollectionTypes(Integer id){
        Genre genre = this.genreRepository.findById(id).orElse(null);
        List<CollectionType> collectionTypeList = new ArrayList<>();

        if(genre != null)
        {


            for(GenreCollectionType genreCollectionType : genre.getGenreCollectionTypes()){
                collectionTypeList.add(genreCollectionType.getCollectionType());
            }

        }
        return collectionTypeList;
    }
}
