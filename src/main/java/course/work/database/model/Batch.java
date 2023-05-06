package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Партия")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Номер_партии")
    private String batchNumber;

    @ManyToOne
    @JoinColumn(name = "Поставщик")
    private Supplier supplier;

    @Column(name = "Количество")
    private long amount;
}
