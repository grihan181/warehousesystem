package course.work.database.service;

import course.work.database.model.SuppliersEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuppliersEmployeeService {

    List<SuppliersEmployee> getAll();
    void save (SuppliersEmployee employeeWarehouse);
    SuppliersEmployee getByID(long id);
    void deleteViaId(long id);

}
