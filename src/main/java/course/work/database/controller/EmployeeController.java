package course.work.database.controller;

import course.work.database.repository.WarehouseRepo;
import course.work.database.service.EmployeeWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeWarehouseService employeeWarehouseService;

    @Autowired
    private WarehouseRepo warehouseRepo;


}
