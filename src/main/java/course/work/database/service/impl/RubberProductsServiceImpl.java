package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.model.RubberProducts;
import course.work.database.repository.ProductRepo;
import course.work.database.repository.RubberProductsRepo;
import course.work.database.service.ProductService;
import course.work.database.service.RubberProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubberProductsServiceImpl implements RubberProductsService {
    @Autowired
    private RubberProductsRepo repo;


    @Override
    public List<RubberProducts> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(RubberProducts rubberProducts) {
        repo.save(rubberProducts);
    }

    @Override
    public RubberProducts getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
