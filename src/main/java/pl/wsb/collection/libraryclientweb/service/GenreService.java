package pl.wsb.collection.libraryclientweb.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.repository.GenreRepository;
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
}
