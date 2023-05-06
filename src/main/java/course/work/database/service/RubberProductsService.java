package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.RubberProducts;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RubberProductsService {

    List<RubberProducts> getAll();
    void save (RubberProducts employeeWarehouse);
    RubberProducts getByID(long id);
    void deleteViaId(long id);



}
