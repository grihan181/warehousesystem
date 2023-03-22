package course.work.database.repository;

import course.work.database.model.RubberProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubberProductsRepo  extends JpaRepository<RubberProducts, Long> {
}
