package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Кассовый_чек")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Дата_покупки")
    private LocalDate timestamp;

    @ManyToOne
    @JoinColumn(name = "Продавец")
    private CompanyEmployee companyEmployee;
}
