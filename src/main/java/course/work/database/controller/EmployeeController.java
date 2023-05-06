package course.work.database.controller;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.Warehouse;
import course.work.database.repository.WarehouseRepo;
import course.work.database.service.BossService;
import course.work.database.service.EmployeeWarehouseService;
import course.work.database.service.impl.EmployeeWarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeWarehouseService employeeWarehouseService;

    @Autowired
    private WarehouseRepo warehouseRepo;


}
