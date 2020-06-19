package pl.wsb.collection.libraryclientweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.collection.libraryclientweb.model.Author;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.repository.GenreRepository;
import pl.wsb.collection.libraryclientweb.service.AuthorService;
import pl.wsb.collection.libraryclientweb.service.GenreService;

import java.util.Date;


@Controller
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listGenries", this.genreService.listAll());
        return "author/index";
    }

    @RequestMapping("/new")
    public String create(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/new";
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("author") Genre genre) {
        genre.setModified(new Date());
        this.genreService.save(genre);
        return "redirect:/author/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("author/edit");
        modelAndView.addObject("author", this.genreService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        this.genreService.delete(id);
        return "redirect:/author/";
    }

}
