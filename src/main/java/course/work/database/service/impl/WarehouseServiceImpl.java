package course.work.database.service.impl;

import course.work.database.model.Warehouse;
import course.work.database.repository.WarehouseRepo;
import course.work.database.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepo repo;


    @Override
    public List<Warehouse> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Warehouse warehouse) {
        repo.save(warehouse);
    }

    @Override
    public Warehouse getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
