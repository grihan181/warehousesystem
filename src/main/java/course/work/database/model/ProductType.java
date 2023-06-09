package course.work.database.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Тип_товара")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Описание")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Раздел_РТИ")
    private RubberProducts rubberProducts;

}
