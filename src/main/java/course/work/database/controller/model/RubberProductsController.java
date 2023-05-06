package course.work.database.controller.model;

import course.work.database.model.RubberProducts;
import course.work.database.service.RubberProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rubberProducts")  //TODO фронт
public class RubberProductsController {

    @Autowired
    private RubberProductsService service;


    @GetMapping("getAll")
    public String getAllRubberProducts(Model model) {
        model.addAttribute("rubberProducts", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewRubberProducts")
    public String addRubberProducts(Model model) {
        RubberProducts rubberProducts = new RubberProducts();
        model.addAttribute("rubberProducts", rubberProducts);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveRubberProducts(@ModelAttribute("rubberProducts") RubberProducts rubberProducts) {
        service.save(rubberProducts);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showRubberProductsByIdForUpdate/{id}")
    public String showRubberProductsByIdForUpdate(@PathVariable long id, Model model) {
        RubberProducts rubberProducts = service.getByID(id);
        model.addAttribute("rubberProducts", rubberProducts);
        return "update";
    }

    @DeleteMapping("deleteRubberProductsById/{id}")
    public String deleteRubberProductsById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
