package course.work.database.controller.model;

import course.work.database.model.Warehouse;
import course.work.database.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouse")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class WarehouseController {

    @Autowired
    private WarehouseService service;


    @GetMapping("getAll")
    public String getAllWarehouse(Model model) {
        model.addAttribute("warehouses", service.getAll());
        return "showAll/showAllWarehouse";
    }
    @GetMapping("addNewWarehouse")
    public String addWarehouse(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        return "updateObject/updateWarehouse";
    }

    @PostMapping("save")
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        service.save(warehouse);
        return "redirect:/warehouse/getAll";
    }

    @GetMapping("showWarehouseByIdForUpdate/{id}")
    public String showWarehouseByIdForUpdate(@PathVariable long id, Model model) {
        Warehouse warehouse = service.getByID(id);
        model.addAttribute("warehouse", warehouse);
        return "updateObject/updateWarehouse";
    }

    @DeleteMapping("deleteWarehouseById/{id}")
    public String deleteWarehouseById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/warehouse/getAll";
    }
}
