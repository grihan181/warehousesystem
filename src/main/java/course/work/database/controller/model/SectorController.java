package course.work.database.controller.model;

import course.work.database.model.Sector;
import course.work.database.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sector")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class SectorController {

    @Autowired
    private SectorService service;


    @GetMapping("getAll")
    public String getAllSector(Model model) {
        model.addAttribute("sectors", service.getAll());
        return "showAll/showAllSector";
    }
    @GetMapping("addNewSector")
    public String addSector(Model model) {
        Sector sector = new Sector();
        model.addAttribute("sector", sector);
        return "updateObject/updateSector";
    }

    @PostMapping("save")
    public String saveSector(@ModelAttribute("sector") Sector sector) {
        service.save(sector);
        return "redirect:/sector/getAll";
    }

    @GetMapping("showSectorByIdForUpdate/{id}")
    public String showSectorByIdForUpdate(@PathVariable long id, Model model) {
        Sector sector = service.getByID(id);
        model.addAttribute("sector", sector);
        return "updateObject/updateSector";
    }

    @DeleteMapping("deleteSectorById/{id}")
    public String deleteSectorById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/sector/getAll";
    }
}
