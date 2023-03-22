package course.work.database.repository;

import course.work.database.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo  extends JpaRepository<Warehouse, Long> {
}
