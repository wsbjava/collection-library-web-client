package pl.wsb.collection.libraryclientweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.service.GenreService;

import java.util.Date;


@Controller
@RequestMapping("/user")
public class UserController {

    private final GenreService genreService;

    public UserController(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping("/login")
    public String userLogin(Model model){
        model.addAttribute("user", null);
        return "user/authenticate/login";
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listGenries", this.genreService.listAll());
        return "genre/index";
    }

    @RequestMapping("/new")
    public String create(Model model){
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "genre/new";
    }

    @RequestMapping("/show-collection-type/{id}")
    public String showCollectionType(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("genre/show-collection-type");
        //modelAndView.addObject("collectionType", )
        return "test";

    }
    @PostMapping("/save")
    public String saveActor(@ModelAttribute("genre") Genre genre) {
        genre.setModified(new Date());
        genre.setAbbr(this.genreService.generateAbbr(genre.getName()));
        this.genreService.save(genre);
        return "redirect:/genre/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("genre/edit");
        modelAndView.addObject("genre", this.genreService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        this.genreService.delete(id);
        return "redirect:/genre/";
    }

}
