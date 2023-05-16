package course.work.database.controller.model;

import course.work.database.model.Supplier;
import course.work.database.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class SupplierController {

    @Autowired
    private SupplierService service;


    @GetMapping("getAll")
    public String getAllSupplier(Model model) {
        model.addAttribute("suppliers", service.getAll());
        return "showAll/showAllSupplier";
    }
    @GetMapping("addNewSupplier")
    public String addSupplier(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "updateObject/updateSupplier";
    }

    @PostMapping("save")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
        service.save(supplier);
        return "redirect:/supplier/getAll";
    }

    @GetMapping("showSupplierByIdForUpdate/{id}")
    public String showSupplierByIdForUpdate(@PathVariable long id, Model model) {
        Supplier supplier = service.getByID(id);
        model.addAttribute("supplier", supplier);
        return "updateObject/updateSupplier";
    }

    @DeleteMapping("deleteSupplierById/{id}")
    public String deleteSupplierById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/supplier/getAll";
    }
}
