package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.repository.ProductRepo;
import course.work.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;


    @Override
    @Cacheable("products")
    public List<Product> getAll() {

        return repo.findAll();
    }

    @Override
    @CachePut("products")
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    @Cacheable("products")
    public Product getByID(long id) {
        return repo.findById(id).get();
    }


    @Override
    @CacheEvict("products")
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }

    @Override
    @Cacheable("products")
    public List<Product> searchAllLike(String searchWord) {
        return repo.findByNameContaining(searchWord);
    }
}
