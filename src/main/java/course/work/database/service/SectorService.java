package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Sector;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SectorService {

    List<Sector> getAll();
    void save (Sector employeeWarehouse);
    Sector getByID(long id);
    void deleteViaId(long id);


}
