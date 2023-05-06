package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeWarehouseService {

    List<EmployeeWarehouse> getAll();
    void save (EmployeeWarehouse employeeWarehouse);
    EmployeeWarehouse getByID(long id);
    void deleteViaId(long id);



    public List<CompanyEmployee> getAllEmployeeWorkersByWarehouse(long warehouseId);

    public List<Warehouse> getWarehouseByEmployeeWorker(long employeeId);

}
