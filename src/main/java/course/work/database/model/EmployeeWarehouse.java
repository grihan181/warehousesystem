package course.work.database.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
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
    private String initialDataWorkInClade;

    @Column(name = "Конечная_дата_работы_на_складе")
    private String finalDataWorkInClade;
}
