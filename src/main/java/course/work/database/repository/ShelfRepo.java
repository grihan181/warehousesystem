package course.work.database.repository;

import course.work.database.model.Sector;
import course.work.database.model.Shelf;
import course.work.database.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelfRepo extends JpaRepository<Shelf, Long> {
    //public Optional<Shelf> findByWarehouse(Sector sector);
}
