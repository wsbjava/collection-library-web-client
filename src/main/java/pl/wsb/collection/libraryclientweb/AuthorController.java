package pl.wsb.collection.libraryclientweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.collection.libraryclientweb.model.Author;
import pl.wsb.collection.libraryclientweb.service.AuthorService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listAuthors", this.authorService.listAll());
        return "author/index";
    }

    @RequestMapping("/new")
    public String create(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "author/new";
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("author") Author author) {
        author.setModified(new Date());
        this.authorService.save(author);
        return "redirect:/author/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("author/edit");
        modelAndView.addObject("author", this.authorService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        this.authorService.delete(id);
        return "redirect:/author/";
    }

}
