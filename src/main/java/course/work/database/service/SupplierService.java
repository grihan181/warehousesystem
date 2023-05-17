package course.work.database.service;

import course.work.database.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {

    List<Supplier> getAll();
    void save (Supplier employeeWarehouse);
    Supplier getByID(long id);
    void deleteViaId(long id);

}
