package course.work.database.controller;

import course.work.database.model.CompanyEmployee;
import course.work.database.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boss")
public class BossController {
    @Autowired
    private BossService bossService;

    @GetMapping("getAllEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("allEmpList", bossService.getAllEmployee());
        return "showAllEmployees";
    }

    @GetMapping("addNewEmployee")
    public String addNewEmployee(Model model) {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        model.addAttribute("employee", companyEmployee);
        return "newEmployee";
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
        return "update";
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        bossService.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
