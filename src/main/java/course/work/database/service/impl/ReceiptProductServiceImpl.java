package course.work.database.service.impl;

import course.work.database.model.ReceiptProduct;
import course.work.database.repository.ReceiptProductRepo;
import course.work.database.service.ReceiptProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptProductServiceImpl implements ReceiptProductService {
    @Autowired
    private ReceiptProductRepo repo;

    @Override
    public List<ReceiptProduct> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(ReceiptProduct receiptProduct) {
        repo.save(receiptProduct);
    }

    @Override
    public ReceiptProduct getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
