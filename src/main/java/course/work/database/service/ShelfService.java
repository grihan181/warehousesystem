package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Shelf;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShelfService {

    List<Shelf> getAll();
    void save (Shelf employeeWarehouse);
    Shelf getByID(long id);
    void deleteViaId(long id);


}
