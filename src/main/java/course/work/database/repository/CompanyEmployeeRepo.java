package course.work.database.repository;

import course.work.database.model.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEmployeeRepo extends JpaRepository<CompanyEmployee, Long> {
}
