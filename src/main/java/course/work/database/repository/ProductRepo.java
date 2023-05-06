package course.work.database.repository;

import course.work.database.model.CompanyEmployee;
import course.work.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo  extends JpaRepository<Product, Long> {
}
