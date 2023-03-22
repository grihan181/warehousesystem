package course.work.database.repository;

import course.work.database.model.ReceiptProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptProductRepo  extends JpaRepository<ReceiptProduct, Long> {
}
