package course.work.database.service.impl;

import course.work.database.model.Batch;
import course.work.database.model.Supplier;
import course.work.database.repository.BatchRepo;
import course.work.database.repository.SupplierRepo;
import course.work.database.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepo repo;

    @Autowired
    private SupplierRepo supplierRepo;


    @Override
    public List<Batch> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Batch batch) {
        Supplier supplier = supplierRepo.findById(batch.getSupplier().getId()).get();
        batch.setSupplier(supplier);
        repo.save(batch);
    }

    @Override
    public Batch getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
