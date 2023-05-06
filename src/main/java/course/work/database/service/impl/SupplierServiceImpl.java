package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.model.Supplier;
import course.work.database.repository.ProductRepo;
import course.work.database.repository.SupplierRepo;
import course.work.database.service.ProductService;
import course.work.database.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepo repo;

    @Override
    public List<Supplier> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        repo.save(supplier);
    }

    @Override
    public Supplier getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
