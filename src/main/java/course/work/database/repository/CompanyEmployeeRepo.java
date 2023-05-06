package course.work.database.repository;

import course.work.database.model.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyEmployeeRepo extends JpaRepository<CompanyEmployee, Long> {
    Optional<CompanyEmployee> findByLogin(String login);
}
