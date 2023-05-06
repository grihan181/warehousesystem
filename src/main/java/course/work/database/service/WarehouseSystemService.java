package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WarehouseSystemService {
    List<Warehouse> getAllWarehouse();
    void save (Warehouse warehouse);
    CompanyEmployee getByID(long id);
    void deleteViaId(long id);
}
