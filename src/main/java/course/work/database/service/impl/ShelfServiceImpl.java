package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.model.Shelf;
import course.work.database.repository.ProductRepo;
import course.work.database.repository.ShelfRepo;
import course.work.database.service.ProductService;
import course.work.database.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfServiceImpl implements ShelfService {
    @Autowired
    private ShelfRepo repo;

    @Override
    public List<Shelf> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Shelf shelf) {
        repo.save(shelf);
    }

    @Override
    public Shelf getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
