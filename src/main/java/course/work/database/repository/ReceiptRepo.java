package course.work.database.repository;

import course.work.database.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepo  extends JpaRepository<Receipt, Long> {
}
