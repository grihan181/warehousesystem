package course.work.database.controller.model;

import course.work.database.model.EmployeeWarehouse;
import course.work.database.service.EmployeeWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employeeWarehouse")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class EmployeeWarehouseController {
    @Autowired
    private EmployeeWarehouseService service;


    @GetMapping("getAll")
    public String getAllEmployeesWarehouse(Model model) {
        model.addAttribute("employeeWarehouses", service.getAll());
        return "showAll/showAllEmployeeWarehouse";
    }
    @GetMapping("addNewEmployeeWarehouse")
    public String addNewEmployeeWarehouse(Model model) {
        EmployeeWarehouse employeeWarehouse = new EmployeeWarehouse();
        model.addAttribute("employeeWarehouse", employeeWarehouse);
        return "updateObject/updateEmployeeWarehouse";
    }

    @PostMapping("save")
    public String saveEmployeeWarehouse(@ModelAttribute("employeeWarehouse") EmployeeWarehouse employeeWarehouse) {
        service.save(employeeWarehouse);
        return "redirect:/employeeWarehouse/getAll";
    }

    @GetMapping("showEmployeeWarehouseByIdForUpdate/{id}")
    public String showEmployeeWarehouseByIdForUpdate(@PathVariable long id, Model model) {
        EmployeeWarehouse employeeWarehouse = service.getByID(id);
        model.addAttribute("employeeWarehouse", employeeWarehouse);
        return "updateObject/updateEmployeeWarehouse";
    }

    @DeleteMapping("deleteEmployeeWarehouseById/{id}")
    public String deleteEmployeeWarehouseById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/employeeWarehouse/getAll";
    }








    @GetMapping("getAllEmployeeWorkersByWarehouse/{id}")
    public String getAllEmployeeWorkersByWarehouse(@PathVariable long warehouseId, Model model) {
        model.addAttribute("employees", service.getAllEmployeeWorkersByWarehouse(warehouseId));
        return "update";
    }
    @PostMapping("getWarehouseByEmployeeWorker/{id}")
    public String getWarehouseByEmployeeWorker(@PathVariable long employeeId, Model model) {
        model.addAttribute("warehouses", service.getWarehouseByEmployeeWorker(employeeId));
        return "update";
    }

}
