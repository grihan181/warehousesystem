package course.work.database.repository;

import course.work.database.model.EmployeeWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeWarehouseRepo  extends JpaRepository<EmployeeWarehouse, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM сотрудник_склад WHERE worker_id = :id")
    List<EmployeeWarehouse> findByCompanyEmployee(@Param("id") long employeeId);

    @Query(nativeQuery = true, value = "SELECT * FROM сотрудник_склад WHERE warehouse_id = :id")
    List<EmployeeWarehouse> findByWarehouseId(@Param("id") long warehouseId);
}
