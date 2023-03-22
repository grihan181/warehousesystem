package course.work.database.repository;

import course.work.database.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo  extends JpaRepository<ProductType, Long> {
}
