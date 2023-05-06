package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.ProductType;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeService {

    List<ProductType> getAll();
    void save (ProductType employeeWarehouse);
    ProductType getByID(long id);
    void deleteViaId(long id);


}
