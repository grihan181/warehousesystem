package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.EmployeeWarehouse;
import course.work.database.model.Receipt;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptService {

    List<Receipt> getAll();
    void save (Receipt employeeWarehouse);
    Receipt getByID(long id);
    void deleteViaId(long id);



}
