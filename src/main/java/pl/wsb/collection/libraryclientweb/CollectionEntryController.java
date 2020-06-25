package pl.wsb.collection.libraryclientweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.collection.libraryclientweb.model.CollectionEntry;
import pl.wsb.collection.libraryclientweb.model.CollectionType;
import pl.wsb.collection.libraryclientweb.model.Genre;
import pl.wsb.collection.libraryclientweb.service.CollectionEntryService;
import pl.wsb.collection.libraryclientweb.service.CollectionTypeService;

import java.util.Date;


@Controller
@RequestMapping("/collection-entry")
public class CollectionEntryController {

    private final CollectionEntryService collectionTypeService;

    public CollectionEntryController(CollectionEntryService collectionTypeService){
        this.collectionTypeService = collectionTypeService;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listEntries", this.collectionTypeService.listAll());
        return "collectrionEntry/index";
    }

    @RequestMapping("/new")
    public String create(Model model){
        CollectionEntry collectionEntry = new CollectionEntry();
        model.addAttribute("collectionEntry", collectionEntry);
        return "collectrionEntry/new";
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("genre") CollectionEntry collectionType) {
        collectionType.setModified(new Date());
        this.collectionTypeService.save(collectionType);
        return "redirect:/collection-entry/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("collectrionEntry/edit");
        modelAndView.addObject("CollectionEntry", this.collectionTypeService.find(id));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        this.collectionTypeService.delete(id);
        return "redirect:/collection-entry/";
    }

}
