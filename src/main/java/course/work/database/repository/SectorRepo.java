package course.work.database.repository;

import course.work.database.model.Sector;
import course.work.database.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepo  extends JpaRepository<Sector, Long> {
    public Optional<Sector> findByWarehouse(Warehouse warehouse);
}
