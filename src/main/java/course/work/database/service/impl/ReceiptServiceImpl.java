package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.model.Receipt;
import course.work.database.repository.ProductRepo;
import course.work.database.repository.ReceiptRepo;
import course.work.database.service.ProductService;
import course.work.database.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ReceiptRepo repo;


    @Override
    public List<Receipt> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Receipt receipt) {
        repo.save(receipt);
    }

    @Override
    public Receipt getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
