package course.work.database.repository;

import course.work.database.model.SuppliersEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersEmployeeRepo  extends JpaRepository<SuppliersEmployee, Long> {
}
