package course.work.database.controller.model;

import course.work.database.model.Shelf;
import course.work.database.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shelf")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class ShelfController {

    @Autowired
    private ShelfService service;


    @GetMapping("getAll")
    public String getAllShelf(Model model) {
        model.addAttribute("shelfs", service.getAll());
        return "showAll/showAllShelf";
    }
    @GetMapping("addNewShelf")
    public String addShelf(Model model) {
        Shelf shelf = new Shelf();
        model.addAttribute("shelf", shelf);
        return "updateObject/updateShelf";
    }

    @PostMapping("save")
    public String saveShelf(@ModelAttribute("shelf") Shelf shelf) {
        service.save(shelf);
        return "redirect:/shelf/getAll";
    }

    @GetMapping("showShelfByIdForUpdate/{id}")
    public String showShelfByIdForUpdate(@PathVariable long id, Model model) {
        Shelf shelf = service.getByID(id);
        model.addAttribute("shelf", shelf);
        return "updateObject/updateShelf";
    }

    @DeleteMapping("deleteShelfById/{id}")
    public String deleteShelfById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/shelf/getAll";
    }
}
