package course.work.database.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Кассовый_чек")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Дата_покупки")
    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "Продавец")
    private CompanyEmployee companyEmployee;
}
