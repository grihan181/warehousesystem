package course.work.database.repository;

import course.work.database.model.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepo extends JpaRepository<Shelf, Long> {
    //public Optional<Shelf> findByWarehouse(Sector sector);
}
