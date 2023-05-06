package course.work.database.controller.model;

import course.work.database.model.Supplier;
import course.work.database.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")  //TODO фронт
public class SupplierController {

    @Autowired
    private SupplierService service;


    @GetMapping("getAll")
    public String getAllSupplier(Model model) {
        model.addAttribute("suppliers", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewSupplier")
    public String addSupplier(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
        service.save(supplier);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showSupplierByIdForUpdate/{id}")
    public String showSupplierByIdForUpdate(@PathVariable long id, Model model) {
        Supplier supplier = service.getByID(id);
        model.addAttribute("supplier", supplier);
        return "update";
    }

    @DeleteMapping("deleteSupplierById/{id}")
    public String deleteSupplierById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
