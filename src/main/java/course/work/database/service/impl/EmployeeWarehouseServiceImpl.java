package course.work.database.service.impl;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Warehouse;
import course.work.database.repository.EmployeeWarehouseRepo;
import course.work.database.service.EmployeeWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeWarehouseServiceImpl implements EmployeeWarehouseService {
    @Autowired
    private EmployeeWarehouseRepo repo;

    @Override
    public List<EmployeeWarehouse> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(EmployeeWarehouse employeeWarehouse) {
        repo.save(employeeWarehouse);
    }

    @Override
    public EmployeeWarehouse getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }



    @Override
    public List<CompanyEmployee> getAllEmployeeWorkersByWarehouse(long warehouseId) {
        List<EmployeeWarehouse> employeeWarehouses = repo.findByWarehouseId(warehouseId);
        List<CompanyEmployee> companyEmployees = new ArrayList<>();

        for(EmployeeWarehouse employeeWarehouse : employeeWarehouses) {
            companyEmployees.add(employeeWarehouse.getCompanyEmployee());
        }
        return companyEmployees;
    }

    @Override
    public List<Warehouse> getWarehouseByEmployeeWorker(long employeeId) {
        List<EmployeeWarehouse> employeeWarehouses = repo.findByCompanyEmployee(employeeId);
        List<Warehouse> warehouses = new ArrayList<>();

        for(EmployeeWarehouse employeeWarehouse : employeeWarehouses) {
            warehouses.add(employeeWarehouse.getWarehouse());
        }
        return warehouses;
    }
}
