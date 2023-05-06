package course.work.database.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Сектор")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Описание_местоположения")
    private String locationDescription;

    @ManyToOne
    @JoinColumn(name = "Склад")
    private Warehouse warehouse;
}
