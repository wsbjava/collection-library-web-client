package pl.wsb.collection.libraryclientweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.service.CollectionTypeService;
import pl.wsb.collection.libraryclientweb.service.GenreService;

import java.util.Date;


@Controller
@RequestMapping("/collection-type")
public class CollectionTypeController {

    private final CollectionTypeService collectionTypeService;

    public CollectionTypeController(CollectionTypeService collectionTypeService){
        this.collectionTypeService = collectionTypeService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listGenries", this.collectionTypeService.listAll());
        return "genre/index";
    }

    @RequestMapping("/new")
    public String create(Model model){
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "genre/new";
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("genre") CollectionType collectionType) {
        collectionType.setModified(new Date());
        collectionType.setAbbr(this.collectionTypeService.generateAbbr(collectionType.getName()));
        this.collectionTypeService.save(collectionType);
        return "redirect:/genre/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("collection-type/edit");
        modelAndView.addObject("genre", this.collectionTypeService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        this.collectionTypeService.delete(id);
        return "redirect:/genre/";
    }

}
