package course.work.database.controller.model;

import course.work.database.model.Batch;
import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Role;
import course.work.database.service.BatchService;
import course.work.database.service.EmployeeWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/batch")
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class BatchController {

    @Autowired
    private BatchService service;


    @GetMapping("getAll")
    public String getAllBatch(Model model) {
        model.addAttribute("batches", service.getAll());
        return "showAll/showAllBatch";
    }
    @GetMapping("addNewBatch")
    public String addNewBatch(Model model) {
        Batch batch = new Batch();
        model.addAttribute("batch", batch);
        return "updateObject/updateBatch";
    }

    @PostMapping("save")
    public String saveBatch(@ModelAttribute("batch") Batch batch) {
        service.save(batch);
        return "redirect:/batch/getAll";
    }

    @GetMapping("showBatchByIdForUpdate/{id}")
    public String showBatchByIdForUpdate(@PathVariable long id, Model model) {
        Batch batch = service.getByID(id);
        model.addAttribute("employeeWarehouse", batch);
        return "updateObject/updateBatch";
    }

    @DeleteMapping("deleteBatchById/{id}")
    public String deleteBatchById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/batch/getAll";
    }
}
