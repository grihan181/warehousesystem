package course.work.database.service;

import course.work.database.model.RubberProducts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RubberProductsService {

    List<RubberProducts> getAll();
    void save (RubberProducts employeeWarehouse);
    RubberProducts getByID(long id);
    void deleteViaId(long id);



}
