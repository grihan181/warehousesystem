package course.work.database.service;

import course.work.database.model.ReceiptProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptProductService {

    List<ReceiptProduct> getAll();
    void save (ReceiptProduct employeeWarehouse);
    ReceiptProduct getByID(long id);
    void deleteViaId(long id);



}
