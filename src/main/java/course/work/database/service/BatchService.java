package course.work.database.service;

import course.work.database.model.Batch;
import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatchService {

    List<Batch> getAll();
    void save (Batch employeeWarehouse);
    Batch getByID(long id);
    void deleteViaId(long id);


}
