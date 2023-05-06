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
@Table(name = "Товар")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Тип_товара")
    private ProductType productType;

    @Column(name = "Описание")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Расположение")
    private Shelf shelf;

    @ManyToOne
    @JoinColumn(name = "Id_партии")
    private Batch batch;

    @Column(name = "Остаток_организации")
    private int remains;

    @Column(name = "Единица_измерения")
    private String unitOfMeasurement;

    @Column(name = "Цена")
    private int price;

    @Column(name = "Дата_прихода")
    private LocalDate arrivalDate;


}
