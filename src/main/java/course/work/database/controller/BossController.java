package course.work.database.controller;

import course.work.database.model.CompanyEmployee;
import course.work.database.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boss")
@PreAuthorize("hasAuthority('ADMIN')")
public class BossController {
    @Autowired
    private BossService bossService;

    @GetMapping("getAllEmployees") //TODO поместить в другой контролллер
    public String getAllEmployees(Model model) {
        model.addAttribute("allEmpList", bossService.getAllEmployee());
        return "showAll/showAllEmployees";
    }
    @GetMapping("addNewEmployee")
    public String addNewEmployee(Model model) {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        model.addAttribute("employee", companyEmployee);
        return "newObject/newEmployee";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") CompanyEmployee companyEmployee) {
        bossService.save(companyEmployee);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showEmployeeByIdForUpdate/{id}")
    public String showEmployeeByIdForUpdate(@PathVariable long id, Model model) {
        CompanyEmployee companyEmployee = bossService.getByID(id);
        model.addAttribute("employee", companyEmployee);
        return "updateObject/updateEmployee";
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        bossService.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
