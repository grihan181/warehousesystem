package course.work.database.service.impl;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.Role;
import course.work.database.model.Status;
import course.work.database.repository.CompanyEmployeeRepo;
import course.work.database.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossServiceImpl implements BossService {

    @Autowired
    private CompanyEmployeeRepo comEmpRep;

    @Override
    public List<CompanyEmployee> getAllEmployee() {
        return comEmpRep.findAll();
    }


    @Override
    public void save(CompanyEmployee companyEmployee) {
        companyEmployee.setPassword(companyEmployee.getPassword());
        companyEmployee.setRole(Role.USER);
        companyEmployee.setStatus(Status.ACTIVE);
        comEmpRep.save(companyEmployee);
    }

    @Override
    public CompanyEmployee getByID(long id) {
        return comEmpRep.findById(id).get();
    }

    @Override
    public void deleteViaId(long id) {
        comEmpRep.deleteById(id);
    }
}
