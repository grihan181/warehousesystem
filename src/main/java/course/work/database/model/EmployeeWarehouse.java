package course.work.database.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Сотрудник_склад")
public class EmployeeWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private CompanyEmployee companyEmployee;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "Начальная_дата_работы_на_складе")
    private LocalDate initialDataWorkInClade;

    @Column(name = "Конечная_дата_работы_на_складе")
    private LocalDate finalDataWorkInClade;
}
