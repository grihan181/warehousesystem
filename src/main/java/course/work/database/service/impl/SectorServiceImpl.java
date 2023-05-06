package course.work.database.service.impl;

import course.work.database.model.Product;
import course.work.database.model.Sector;
import course.work.database.repository.ProductRepo;
import course.work.database.repository.SectorRepo;
import course.work.database.service.ProductService;
import course.work.database.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {
    @Autowired
    private SectorRepo repo;

    @Override
    public List<Sector> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Sector sector) {
        repo.save(sector);
    }

    @Override
    public Sector getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}


