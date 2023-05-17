package course.work.database.controller;

import course.work.database.model.CompanyEmployee;
import course.work.database.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boss")
public class BossController {
    @Autowired
    private BossService bossService;

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping("getAllEmployees")
    public String getAllEmployees(Model model) {
        model.addAttribute("allEmpList", bossService.getAllEmployee());
        return "showAll/showAllEmployees";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("addNewEmployee")
    public String addNewEmployee(Model model) {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        model.addAttribute("employee", companyEmployee);
        return "updateObject/updateEmployee";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") CompanyEmployee companyEmployee) {
        bossService.save(companyEmployee);
        return "redirect:/boss/getAllEmployees";
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping("showEmployeeByIdForUpdate/{id}")
    public String showEmployeeByIdForUpdate(@PathVariable long id, Model model) {
        CompanyEmployee companyEmployee = bossService.getByID(id);
        model.addAttribute("employee", companyEmployee);
        return "updateObject/updateEmployee";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        bossService.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
