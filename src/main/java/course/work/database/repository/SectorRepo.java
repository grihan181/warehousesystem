package course.work.database.repository;

import course.work.database.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepo  extends JpaRepository<Sector, Long> {
}
