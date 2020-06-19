package pl.wsb.collection.libraryclientweb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.collection.libraryclientweb.model.Author;
import pl.wsb.collection.libraryclientweb.repository.AuthorRepository;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> listAll(){
        return this.authorRepository.findAll();
    }

    public void save(Author author){
        this.authorRepository.save(author);
    }

    public Author find(Integer id){
        return this.authorRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        this.authorRepository.deleteById(id);
    }

}
