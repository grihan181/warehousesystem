package course.work.database.service;

import course.work.database.model.Batch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatchService {

    List<Batch> getAll();
    void save (Batch employeeWarehouse);
    Batch getByID(long id);
    void deleteViaId(long id);


}
