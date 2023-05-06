package course.work.database.service.impl;

import course.work.database.model.SuppliersEmployee;
import course.work.database.repository.SuppliersEmployeeRepo;
import course.work.database.service.SuppliersEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersEmployeeServiceImpl implements SuppliersEmployeeService {
    @Autowired
    private SuppliersEmployeeRepo repo;

    @Override
    public List<SuppliersEmployee> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(SuppliersEmployee suppliersEmployee) {
        repo.save(suppliersEmployee);
    }

    @Override
    public SuppliersEmployee getByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        repo.deleteById(id);
    }
}
