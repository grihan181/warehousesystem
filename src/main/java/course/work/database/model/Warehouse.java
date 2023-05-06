package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Склад")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "Складской_телефон")
    private String warehousePhone;

    @Column(name = "Площадь")
    private String square;
}
