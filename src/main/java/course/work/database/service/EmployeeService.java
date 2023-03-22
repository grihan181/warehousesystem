package course.work.database.service;

import course.work.database.model.CompanyEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<CompanyEmployee> getAllEmployee();
    void save (CompanyEmployee companyEmployee);
    CompanyEmployee getByID(long id);
    void deleteViaId(long id);
}
