package course.work.database.controller.model;

import course.work.database.model.Sector;
import course.work.database.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sector")  // TODO фронт
public class SectorController {

    @Autowired
    private SectorService service;


    @GetMapping("getAll")
    public String getAllSector(Model model) {
        model.addAttribute("sectors", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewSector")
    public String addSector(Model model) {
        Sector sector = new Sector();
        model.addAttribute("sector", sector);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveSector(@ModelAttribute("sector") Sector sector) {
        service.save(sector);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showSectorByIdForUpdate/{id}")
    public String showSectorByIdForUpdate(@PathVariable long id, Model model) {
        Sector sector = service.getByID(id);
        model.addAttribute("sector", sector);
        return "update";
    }

    @DeleteMapping("deleteSectorById/{id}")
    public String deleteSectorById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
