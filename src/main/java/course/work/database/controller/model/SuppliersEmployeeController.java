package course.work.database.controller.model;

import course.work.database.model.SuppliersEmployee;
import course.work.database.service.SuppliersEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliersEmployee")  //TODO фронт
public class SuppliersEmployeeController {

    @Autowired
    private SuppliersEmployeeService service;


    @GetMapping("getAll")
    public String getAllSuppliersEmployee(Model model) {
        model.addAttribute("suppliersEmployees", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewSuppliersEmployee")
    public String addSuppliersEmployee(Model model) {
        SuppliersEmployee suppliersEmployee = new SuppliersEmployee();
        model.addAttribute("suppliersEmployee", suppliersEmployee);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveSuppliersEmployee(@ModelAttribute("suppliersEmployee") SuppliersEmployee suppliersEmployee) {
        service.save(suppliersEmployee);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showSuppliersEmployeeByIdForUpdate/{id}")
    public String showSuppliersEmployeeByIdForUpdate(@PathVariable long id, Model model) {
        SuppliersEmployee suppliersEmployee = service.getByID(id);
        model.addAttribute("suppliersEmployee", suppliersEmployee);
        return "update";
    }

    @DeleteMapping("deleteSuppliersEmployeeById/{id}")
    public String deleteSuppliersEmployeeById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
