package course.work.database.repository;

import course.work.database.model.EmployeeWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeWarehouseRepo  extends JpaRepository<EmployeeWarehouse, Long> {
}
