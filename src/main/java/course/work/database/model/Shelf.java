package course.work.database.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Стеллаж")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Описание_местоположения")
    private String locationDescription;

    @ManyToOne
    @JoinColumn(name = "Сектор")
    private Sector sector;
}
