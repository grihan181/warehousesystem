package course.work.database.service.impl;

import course.work.database.model.ProductType;
import course.work.database.repository.ProductTypeRepo;
import course.work.database.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepo repo;

    @Override
    public List<ProductType> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(ProductType productType) {
        repo.save(productType);
    }

    @Override
    public ProductType getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
