package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.repository.ProductRepo;
import course.work.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> getAll() {

        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
