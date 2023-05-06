package course.work.database.controller.model;

import course.work.database.model.Warehouse;
import course.work.database.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouse")  //TODO фронт
public class WarehouseController {

    @Autowired
    private WarehouseService service;


    @GetMapping("getAll")
    public String getAllWarehouse(Model model) {
        model.addAttribute("warehouses", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewWarehouse")
    public String addWarehouse(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        service.save(warehouse);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showWarehouseByIdForUpdate/{id}")
    public String showWarehouseByIdForUpdate(@PathVariable long id, Model model) {
        Warehouse warehouse = service.getByID(id);
        model.addAttribute("warehouse", warehouse);
        return "update";
    }

    @DeleteMapping("deleteWarehouseById/{id}")
    public String deleteWarehouseById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
